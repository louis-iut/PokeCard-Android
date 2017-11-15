package com.example.louis.pokecard_android.presentation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.louis.pokecard_android.presentation.navigator.LoginNavigator;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.example.louis.pokecard_android.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {

    private LoginNavigator loginNavigator;

    CallbackManager callbackManager = CallbackManager.Factory.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginNavigator = new LoginNavigator(getFragmentManager());
        loginNavigator.launchLoginFragment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginNavigator.getCurrentFragment().onActivityResult(requestCode, resultCode, data);
    }
}
