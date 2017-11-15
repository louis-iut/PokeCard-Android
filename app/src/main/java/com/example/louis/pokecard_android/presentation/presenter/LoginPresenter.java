package com.example.louis.pokecard_android.presentation.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.louis.pokecard_android.data.Repository;
import com.example.louis.pokecard_android.presentation.view.LoginView;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by iem on 15/11/2017.
 */

public class LoginPresenter {

    private LoginView loginView;
    private Context context;


    public LoginPresenter(LoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;

    }

    public FacebookCallback<LoginResult> setButtonClickListener() {
        return new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                GraphRequest request = new GraphRequest(
                        loginResult.getAccessToken(),
                        "/" + loginResult.getAccessToken().getUserId(),
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                Log.e("response", response.getRawResponse());
                            }
                        }
                );
                Bundle parameters = new Bundle();
                parameters.putString("fields","id,first_name,last_name,email,name,picture");
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {
                Log.e("success","1");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.e("success","2");
            }

        };
    }

}
