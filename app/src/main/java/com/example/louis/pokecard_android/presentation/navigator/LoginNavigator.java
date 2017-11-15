package com.example.louis.pokecard_android.presentation.navigator;

import android.app.Fragment;
import android.app.FragmentManager;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.fragment.LoginFragment;
import com.example.louis.pokecard_android.presentation.view.LoginView;

/**
 * Created by iem on 15/11/2017.
 */

public class LoginNavigator {
    private FragmentManager fragmentManager;

    private final static int LOGIN_FRAGMENT = 0;
    private final static int SIGNUP_FRAGMENT = 0;
    private int currentFragment;


    public LoginNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void launchLoginFragment() {
        LoginView loginView = LoginFragment.newInstance();

        fragmentManager
                .beginTransaction()
                .addToBackStack("pokeListView")
                .add(R.id.login_frame_layout, (Fragment) loginView)
                .commit();

        currentFragment = LOGIN_FRAGMENT;
    }


    public void backAction() {
        if (currentFragment == SIGNUP_FRAGMENT) {
            fragmentManager.popBackStack();
            currentFragment = LOGIN_FRAGMENT;
        }
    }

    public Fragment getCurrentFragment() {
        return fragmentManager.findFragmentById(R.id.login_frame_layout);
    }
}
