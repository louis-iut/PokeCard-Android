package com.example.louis.pokecard_android.presentation.presenter;

/**
 * Created by louis on 18/10/2017.
 */

public class PokemonListPresenter {
<<<<<<< Updated upstream
=======

    private Repository repository;
    private PokemonListView pokemonListView;
    private PokemonNavigatorListener pokemonNavigatorListener;

    public PokemonListPresenter(Repository repository, PokemonNavigatorListener pokemonNavigatorListener) {
        this.repository = repository;
        this.pokemonNavigatorListener = pokemonNavigatorListener;
    }

    public void setPokemonListView(PokemonListView pokemonListView) {
        this.pokemonListView = pokemonListView;
    }

    public void getPokemonList() {
        observe(repository.getPokemonList());
    }

    private void observe(Observable<List<Pokemon>> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Pokemon>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        pokemonListView.snackbarNoConnexion();
                    }

                    @Override
                    public void onNext(List<Pokemon> pokemonList) {
                        pokemonListView.updateList(pokemonList);
                    }
                });
    }

    public void onClickOnComicsList(int id) {
        pokemonNavigatorListener.displayPokemonDetail(id);
    }
>>>>>>> Stashed changes
}
