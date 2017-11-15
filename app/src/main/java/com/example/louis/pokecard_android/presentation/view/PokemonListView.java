package com.example.louis.pokecard_android.presentation.view;

import com.example.louis.pokecard_android.data.entity.Pokemon;

import java.util.List;

/**
 * Created by louis on 18/10/2017.
 */

public interface PokemonListView {

    void updateList(List<Pokemon> pokemonList);
    void changeList(boolean onlyUserPokemons);
    void snackbarNoConnexion();
}
