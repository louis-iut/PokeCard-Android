package com.example.louis.pokecard_android.presentation.listener;

/**
 * Created by louis on 18/10/2017.
 */

public interface PokemonNavigatorListener {

    void displayPokemonDetail(int id);
    void displayPokemonList();
    void onBackPressed();
    void shareAction(String url);
}
