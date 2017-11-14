package com.example.louis.pokecard_android.presentation.view;

import com.example.louis.pokecard_android.data.entity.Pokemon;

/**
 * Created by louis on 12/11/2017.
 */

public interface PokemonDetailView {

    void updateUI(Pokemon pokemon);
    void snackbarNoConnexion();
}
