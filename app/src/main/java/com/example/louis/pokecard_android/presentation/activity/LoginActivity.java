package com.example.louis.pokecard_android.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.louis.pokecard_android.PokeCardApp;
import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.repository.LoginRepository;
import com.example.louis.pokecard_android.presentation.component.MenuDrawer;
import com.example.louis.pokecard_android.presentation.listener.LoginNavigatorListener;
import com.example.louis.pokecard_android.presentation.navigator.LoginNavigator;

public class LoginActivity extends AppCompatActivity implements LoginNavigatorListener {

    private LoginNavigator loginNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // MenuDrawer menuDrawer = PokeCardApp.getInstance().getMenuDrawer();
        //menuDrawer.createNavigationDrawer(this);

        LoginRepository loginRepository = PokeCardApp.getInstance().getLoginRepository();
        loginRepository.loginRequest("TEST", "OK");

        loginNavigator = new LoginNavigator(getFragmentManager());
        loginNavigator.launchLoginFragment();
    }

    @Override
    public void displayLogin() {
        loginNavigator.launchLoginFragment();
    }

    @Override
    public void displayPseudoChoosing() {
        loginNavigator.launchPseudoChoosingFragment();
    }
}
