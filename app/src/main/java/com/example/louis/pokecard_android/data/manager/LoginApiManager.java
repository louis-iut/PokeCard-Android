package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.UserRemoteEntity;

import rx.Observable;

/**
 * Created by louis on 11/12/2017.
 */

public interface LoginApiManager {

    Observable<UserRemoteEntity> loginRequest(String id, String password);
}
