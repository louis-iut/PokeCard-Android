package com.example.louis.pokecard_android.presentation.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.activity.LoginActivity;
import com.example.louis.pokecard_android.presentation.activity.PokemonActivity;
import com.example.louis.pokecard_android.presentation.listener.LoginClickListener;
import com.example.louis.pokecard_android.presentation.presenter.LoginPresenter;
import com.example.louis.pokecard_android.presentation.view.LoginView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iem on 15/11/2017.
 */

public class LoginFragment extends Fragment implements LoginClickListener, LoginView {

    @BindView(R.id.login_facebook_button)

    LoginButton loginButton;
    LoginPresenter loginPresenter;
    private CallbackManager callbackManager = CallbackManager.Factory.create();

    private View view;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        loginPresenter = new LoginPresenter(this, getActivity());
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {
                Log.e("ERROR",exception.toString());
            }

        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClickOnFacebookLogin() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void snackbarNoConnexion() {
        Toast toast = Toast.makeText(getActivity(), "No connexion", Toast.LENGTH_SHORT);
        toast.show();
    }
}
