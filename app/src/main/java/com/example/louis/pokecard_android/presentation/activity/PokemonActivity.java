package com.example.louis.pokecard_android.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.louis.pokecard_android.PokeCardApp;
import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.component.MenuDrawer;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;
import com.example.louis.pokecard_android.presentation.navigator.PokemonNavigator;

import static com.example.louis.pokecard_android.presentation.navigator.MenuNavigator.ONLY_USER_POMEKONS_KEY;

public class PokemonActivity extends AppCompatActivity implements PokemonNavigatorListener {

    private PokemonNavigator pokemonNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        MenuDrawer menuDrawer = PokeCardApp.getInstance().getMenuDrawer();
        menuDrawer.createNavigationDrawer(this);

        boolean onlyUserPokemons;
        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null && intent.getExtras().containsKey(ONLY_USER_POMEKONS_KEY)) {
            onlyUserPokemons = intent.getExtras().getBoolean(ONLY_USER_POMEKONS_KEY);
        } else {
            onlyUserPokemons = true;
        }

        pokemonNavigator = new PokemonNavigator(getFragmentManager());
        pokemonNavigator.launchPokemonListFragment(onlyUserPokemons);
    }

    @Override
    public void displayPokemonDetail(int id) {
        pokemonNavigator.launchDetailFragment(id);
    }

    @Override
    public void displayPokemonList(boolean onlyUserPokemons) {
        pokemonNavigator.launchPokemonListFragment(onlyUserPokemons);
    }

    @Override
    public void shareAction(String url) {}

    @Override
    public void onBackPressed() {
        pokemonNavigator.backAction();
    }

    @Override
    public void changeList(boolean onlyUserPokemons) {
        pokemonNavigator.changePokemonList(onlyUserPokemons);
    }
}
