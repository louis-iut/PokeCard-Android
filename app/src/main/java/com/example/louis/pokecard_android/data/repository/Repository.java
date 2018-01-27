package com.example.louis.pokecard_android.data.repository;

import com.example.louis.pokecard_android.data.entity.PokemonRemoteEntity;
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

    public Observable<List<Member>> getMembers() {
        return membersApiManager.getMembers();
    }

    public Observable<List<PokemonRemoteEntity>> getPokemonList() {
        return pokeApiManager.getPokemonList(0, 800);
    }

    public Observable<List<PokemonRemoteEntity>> getPokemonListOfUser() {
        return pokeApiManager.getPokemonListOfUser(0);
    }

    public Observable<PokemonRemoteEntity> getPokemon(int id) {
        return pokeApiManager.getPokemon(id);
    }

    public Observable<Member> getMember(int id) {

        return membersApiManager.getMember(id);
    }

}
