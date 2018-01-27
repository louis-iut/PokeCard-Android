package com.example.louis.pokecard_android.presentation.presenter;

import android.util.Log;

import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.data.entity.UserRemoteEntity;
import com.example.louis.pokecard_android.data.repository.Repository;
import com.example.louis.pokecard_android.presentation.listener.LoginNavigatorListener;
import com.example.louis.pokecard_android.presentation.view.LoginView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 11/12/2017.
 */

public class LoginPresenter {

    private Repository repository;
    private LoginView loginView;
    private LoginNavigatorListener loginNavigatorListener;

    public LoginPresenter(Repository repository, LoginNavigatorListener loginNavigatorListener) {
        this.repository = repository;
        this.loginNavigatorListener = loginNavigatorListener;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void observe(Observable<UserRemoteEntity> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserRemoteEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("LOGIN", e.toString());
                    }

                    @Override
                    public void onNext(UserRemoteEntity userRemoteEntity) {

                    }
                });
    }


}
