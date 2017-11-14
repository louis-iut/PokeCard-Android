package com.example.louis.pokecard_android.presentation.navigator;

import android.app.Fragment;
import android.app.FragmentManager;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.fragment.PokemonDetailFragment;
import com.example.louis.pokecard_android.presentation.fragment.PokemonListFragment;
import com.example.louis.pokecard_android.presentation.view.PokemonDetailView;
import com.example.louis.pokecard_android.presentation.view.PokemonListView;

/**
 * Created by louis on 18/10/2017.
 */

public class PokemonNavigator {

    private FragmentManager fragmentManager;

    private final static int POKE_LIST_FRAGMENT = 0;
    private final static int POKE_DETAIL_FRAGMENT = 1;
    private int currentFragment;

    public PokemonNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void launchPokemonListFragment() {
        PokemonListView pokemonListView = PokemonListFragment.newInstance();

        fragmentManager
                .beginTransaction()
                .addToBackStack("pokeListView")
                .add(R.id.frame_layout, (Fragment) pokemonListView)
                .commit();

        currentFragment = POKE_LIST_FRAGMENT;
    }

    public void launchDetailFragment(int id) {
        PokemonDetailView pokemonDetailView = PokemonDetailFragment.newInstance(id);

        fragmentManager
                .beginTransaction()
                .addToBackStack("pokeDetailView")
                .replace(R.id.frame_layout, (Fragment) pokemonDetailView)
                .commit();

        currentFragment = POKE_DETAIL_FRAGMENT;
    }

    public void backAction() {
        if (currentFragment == POKE_DETAIL_FRAGMENT) {
            fragmentManager.popBackStack();
            currentFragment = POKE_LIST_FRAGMENT;
        }
    }

    /*public void shareAction(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(intent,"Share via"));
    }*/
}
