package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.PokemonRemoteEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by louis on 18/10/2017.
 */

public interface PokeApiManager {

    Observable<List<PokemonRemoteEntity>> getPokemonList(int page, int number);
    Observable<List<PokemonRemoteEntity>> getPokemonListOfUser(int userId);
    Observable<PokemonRemoteEntity> getPokemon(int id);
}
