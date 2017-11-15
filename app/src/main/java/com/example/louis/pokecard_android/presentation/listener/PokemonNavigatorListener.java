package com.example.louis.pokecard_android.presentation.listener;

/**
 * Created by louis on 18/10/2017.
 */

public interface PokemonNavigatorListener {

    void displayPokemonDetail(int id);
    void displayPokemonList(boolean onlyUserPokemons);
    void changeList(boolean onlyUserPokemons);
    void onBackPressed();
    void shareAction(String url);
}
