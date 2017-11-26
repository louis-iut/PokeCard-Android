package com.example.louis.pokecard_android.presentation.navigator;

import android.app.Activity;
import android.content.Intent;

import com.example.louis.pokecard_android.presentation.activity.MemberActivity;
import com.example.louis.pokecard_android.presentation.activity.PokemonActivity;

/**
 * Created by louis on 14/11/2017.
 */

public class MenuNavigator {

    public static final String ONLY_USER_POMEKONS_KEY = "com.example.louis.pokecard_android.presentation.navigator.MenuNavigator.ONLY_USER_POMEKONS_KEY";

    public void launchPokemonActivity(Activity activity, boolean onlyUserPokemons) {
        Intent intent = new Intent(activity, PokemonActivity.class);
       intent.putExtra(ONLY_USER_POMEKONS_KEY, onlyUserPokemons);

        activity.startActivity(intent);
        activity.finish();
    }

    public void launchMembersActivity(Activity activity) {
        Intent intent = new Intent(activity, MemberActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public void changeList(Activity activity, boolean onlyUserPokemons) {
        ((PokemonActivity) activity).changeList(onlyUserPokemons);
    }
}