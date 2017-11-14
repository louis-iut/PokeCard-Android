package com.example.louis.pokecard_android.presentation.presenter;

import com.example.louis.pokecard_android.data.Repository;
import com.example.louis.pokecard_android.data.entity.User;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;
import com.example.louis.pokecard_android.presentation.view.PokemonListView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 18/10/2017.
 */

public class UserListPresenter {

    private PokemonListView pokemonListView;
    private PokemonNavigatorListener pokemonNavigatorListener;
    private Repository repository;

    public UserListPresenter(PokemonListView pokemonListView, PokemonNavigatorListener pokemonNavigatorListener, Repository repository) {
        this.pokemonListView = pokemonListView;
        this.pokemonNavigatorListener = pokemonNavigatorListener;
        this.repository = repository;
    }

    public void getUsersFromApi() {
        observe(repository.getUsers());
    }

    private void observe(Observable<List<User>> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        //pokemonListView.();
                    }

                    @Override
                    public void onNext(List<User> users) {
                        //.updateList(users);
                    }
                });
    }
}
