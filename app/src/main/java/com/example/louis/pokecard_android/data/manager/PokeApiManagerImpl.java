package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.Pokemon;

import java.util.List;

import rx.Observable;

/**
 * Created by louis on 18/10/2017.
 */

public class PokeApiManagerImpl implements PokeApiManager {
    @Override
    public Observable<List<Pokemon>> getPokemonList() {
        return null;
    }

    @Override
    public Observable<Pokemon> getPokemon(int id) {
        return null;
    }
}
