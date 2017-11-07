package com.example.louis.pokecard_android.data;

import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.data.entity.User;
import com.example.louis.pokecard_android.data.manager.PokeApiManager;
import com.example.louis.pokecard_android.data.manager.UsersApiManager;

import java.util.List;

import rx.Observable;

/**
 * Created by louis on 18/10/2017.
 */

public class Repository {

    private UsersApiManager usersApiManager;
    private PokeApiManager pokeApiManager;

    public Repository(UsersApiManager usersApiManager) {
        this.usersApiManager = usersApiManager;
    }

    public Observable<List<User>> getUsers() {
        return usersApiManager.getUsers();
    }

    public Observable<List<Pokemon>> getPokemons() {
        return pokeApiManager.getPokemons();
    }


}
