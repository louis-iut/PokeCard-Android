package com.example.louis.pokecard_android.presentation.presenter;

import com.example.louis.pokecard_android.data.repository.Repository;
import com.example.louis.pokecard_android.data.entity.PokemonRemoteEntity;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;
import com.example.louis.pokecard_android.presentation.view.PokemonDetailView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 12/11/2017.
 */

public class PokemonDetailPresenter {

    private Repository repository;
    private PokemonDetailView pokemonDetailView;
    private PokemonNavigatorListener pokemonNavigatorListener;

    public PokemonDetailPresenter(Repository repository, PokemonNavigatorListener pokemonNavigatorListener) {
        this.repository = repository;
        this.pokemonNavigatorListener = pokemonNavigatorListener;
    }

    public void setPokemonDetailView(PokemonDetailView pokemonDetailView) {
        this.pokemonDetailView = pokemonDetailView;
    }

    public void getPokemon(int id) {
        observe(repository.getPokemon(id));
    }

    private void observe(Observable<PokemonRemoteEntity> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PokemonRemoteEntity>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        pokemonDetailView.snackbarNoConnexion();
                    }

                    @Override
                    public void onNext(PokemonRemoteEntity pokemon) {
                        pokemonDetailView.updateUI(pokemon);
                    }
                });
    }

    public void backAction() {
        pokemonNavigatorListener.onBackPressed();
    }
}
