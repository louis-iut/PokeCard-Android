package com.example.louis.pokecard_android;

import android.app.Application;

import com.example.louis.pokecard_android.data.Repository;
import com.example.louis.pokecard_android.data.manager.MembersApiMangerMock;
import com.example.louis.pokecard_android.data.manager.PokeApiManager;
import com.example.louis.pokecard_android.data.manager.PokeApiManagerMock;
import com.example.louis.pokecard_android.data.manager.MembersApiManager;
import com.example.louis.pokecard_android.data.manager.MembersApiManagerImpl;

/**
 * Created by louis on 18/10/2017.
 */

public class PokeCardApp extends Application{

    private static PokeCardApp pokeCardApp;

    MembersApiManager membersApiManager;
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
        membersApiManager = new MembersApiMangerMock();
        //membersApiManager = new MembersApiManagerImpl();
        pokeApiManager = new PokeApiManagerMock();
        //pokeApiManager = new PokeApiManagerImpl();
    }

    private void initRepository() {
        repository = new Repository(membersApiManager, pokeApiManager);
    }

    public MembersApiManager getMembersApiManager() {
        return membersApiManager;
    }

    public PokeApiManager getPokeApiManager() {
        return pokeApiManager;
    }

    public Repository getRepository() {
        return repository;
    }
}
