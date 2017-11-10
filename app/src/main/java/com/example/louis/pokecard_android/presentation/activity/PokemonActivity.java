package com.example.louis.pokecard_android.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.Repository;
import com.example.louis.pokecard_android.presentation.navigator.PokemonNavigator;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;

public class PokemonActivity extends AppCompatActivity implements PokemonNavigatorListener {

    private PokemonNavigator pokemonNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokemonNavigator = new PokemonNavigator(getFragmentManager());
        pokemonNavigator.launchPokemonListFragment();
    }

    @Override
    public void displayPokemonDetail(int id) {
        pokemonNavigator.launchDetailFragment(id);
    }

    @Override
    public void displayPokemonList() {
        pokemonNavigator.launchPokemonListFragment();
    }

    @Override
    public void shareAction(String url) {

    }

    @Override
    public void onBackPressed() {
        pokemonNavigator.backAction();
    }
}
