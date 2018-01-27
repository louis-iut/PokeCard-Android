package com.example.louis.pokecard_android.data.repository;

import com.example.louis.pokecard_android.data.entity.UserRemoteEntity;
import com.example.louis.pokecard_android.data.manager.LoginApiManager;

import rx.Observable;

/**
 * Created by louis on 11/12/2017.
 */

public class LoginRepository {

    LoginApiManager loginApiManager;

    public LoginRepository(LoginApiManager loginApiManager) {
        this.loginApiManager = loginApiManager;
    }

    public Observable<UserRemoteEntity> loginRequest(String id, String password) {
        return loginApiManager.loginRequest(id, password);
    }
}
