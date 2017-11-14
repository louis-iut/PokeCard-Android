package com.example.louis.pokecard_android;

import android.app.Application;

import com.example.louis.pokecard_android.data.Repository;
import com.example.louis.pokecard_android.data.manager.PokeApiManager;
import com.example.louis.pokecard_android.data.manager.PokeApiManagerImpl;
import com.example.louis.pokecard_android.data.manager.PokeApiManagerMock;
import com.example.louis.pokecard_android.data.manager.UsersApiManager;
import com.example.louis.pokecard_android.data.manager.UsersApiManagerImpl;

/**
 * Created by louis on 18/10/2017.
 */

public class PokeCardApp extends Application{

    private static PokeCardApp pokeCardApp;

    UsersApiManager usersApiManager;
    PokeApiManager pokeApiManager;
    Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();

        pokeCardApp = this;

        initManagers();
        initRepository();
    }

    public static PokeCardApp getInstance() {
        return pokeCardApp;
    }

    private void initManagers() {
        usersApiManager = new UsersApiManagerImpl();
        pokeApiManager = new PokeApiManagerMock();
        //pokeApiManager = new PokeApiManagerImpl();
    }

    private void initRepository() {
        repository = new Repository(usersApiManager, pokeApiManager);
    }

    public UsersApiManager getUsersApiManager() {
        return usersApiManager;
    }

    public PokeApiManager getPokeApiManager() {
        return pokeApiManager;
    }

    public Repository getRepository() {
        return repository;
    }
}
