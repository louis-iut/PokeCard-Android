package com.example.louis.pokecard_android.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.component.NavigationDrawer;
import com.example.louis.pokecard_android.presentation.component.NavigationDrawerImpl;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;
import com.example.louis.pokecard_android.presentation.navigator.MainNavigator;
import com.example.louis.pokecard_android.presentation.navigator.PokemonNavigator;

public class PokemonActivity extends AppCompatActivity implements PokemonNavigatorListener {

    private PokemonNavigator pokemonNavigator;
    private MainNavigator mainNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        NavigationDrawer navigationDrawer = new NavigationDrawerImpl();
        navigationDrawer.createNavigationDrawer(this);

        mainNavigator = new MainNavigator();
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
    public void shareAction(String url) {}

    @Override
    public void onBackPressed() {
        pokemonNavigator.backAction();
    }
}
