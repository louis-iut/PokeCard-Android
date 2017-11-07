package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.Pokemon;

import java.util.List;

import rx.Observable;

/**
 * Created by louis on 18/10/2017.
 */

public interface PokeApiManager {

    Observable<List<Pokemon>> getPokemons();
}
