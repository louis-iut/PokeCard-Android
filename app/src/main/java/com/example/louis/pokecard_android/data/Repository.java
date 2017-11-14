package com.example.louis.pokecard_android.data;

import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.data.manager.PokeApiManager;
import com.example.louis.pokecard_android.data.manager.MembersApiManager;

import java.util.List;

import rx.Observable;

/**
 * Created by louis on 18/10/2017.
 */

public class Repository {

    private MembersApiManager membersApiManager;
    private PokeApiManager pokeApiManager;

    public Repository(MembersApiManager membersApiManager, PokeApiManager pokeApiManager) {
        this.membersApiManager = membersApiManager;
        this.pokeApiManager = pokeApiManager;
    }

    public Observable<List<Member>> getUsers() {
        return membersApiManager.getUsers();
    }

    public Observable<List<Pokemon>> getPokemonList() {
        return pokeApiManager.getPokemonList();
    }

    public Observable<Pokemon> getPokemon(int id) {
        return pokeApiManager.getPokemon(id);
    }


}
