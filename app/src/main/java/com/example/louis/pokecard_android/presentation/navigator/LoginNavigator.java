package com.example.louis.pokecard_android.presentation.navigator;

import android.app.Fragment;
import android.app.FragmentManager;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.fragment.LoginFragment;
import com.example.louis.pokecard_android.presentation.view.LoginView;

/**
 * Created by louis on 11/12/2017.
 */

public class LoginNavigator {

    private FragmentManager fragmentManager;

    private final static int LOGIN_FRAGMENT = 0;
    private final static int PSEUDO_CHOOSING_FRAGMENT = 1;
    private int currentFragment;

    public LoginNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void launchLoginFragment() {
        LoginView loginView = LoginFragment.newInstance();

        fragmentManager
                .beginTransaction()
                .addToBackStack("loginView")
                .add(R.id.frame_layout, (Fragment) loginView)
                .commit();

        currentFragment = LOGIN_FRAGMENT;
    }

    public void launchPseudoChoosingFragment() {
        /*

        fragmentManager
                .beginTransaction()
                .addToBackStack("memberDetailView")
                .replace(R.id.frame_layout, (Fragment) memberDetailView)
                .commit();

        currentFragment = PSEUDO_CHOOSING_FRAGMENT;*/
    }

    public void backAction() {

    }
}
