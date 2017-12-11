package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.PokemonRemoteEntity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by louis on 11/11/2017.
 */

public class PokeApiManagerMock implements PokeApiManager {

    private final static int LIST_SIZE = 10;
    private final static String IMAGE_URL = "https://s1.qwant.com/thumbr/0x0/8/1/022137aa67fc64d27a6a3fc55a3222/" +
            "b_1_q_0_p_0.jpg?u=https%3A%2F%2Fs-media-cache-ak0.pinimg.com%2F736x%2F80%2Fee%2F66%2F8" +
            "0ee66be8983402966edf0e9b35735b7.jpg&q=0&b=1&p=0&a=1";
    private List<PokemonRemoteEntity> pokemonList;

    @Override
    public Observable<List<PokemonRemoteEntity>> getPokemonList(int page, int number) {
        return Observable.defer(new Func0<Observable<List<PokemonRemoteEntity>>>() {
            @Override
            public Observable<List<PokemonRemoteEntity>> call() {
                return Observable.just(createPokeListMock());
            }
        });
    }

    @Override
    public Observable<List<PokemonRemoteEntity>> getPokemonListOfUser(int id) {
        return Observable.defer(new Func0<Observable<List<PokemonRemoteEntity>>>() {
            @Override
            public Observable<List<PokemonRemoteEntity>> call() {
                return Observable.just(createPokeListMock().subList(0, 2));
            }
        });
    }

    @Override
    public Observable<PokemonRemoteEntity> getPokemon(int id) {
        return Observable.just(pokemonList.get(id));
    }

    private List<PokemonRemoteEntity> createPokeListMock() {
        List<PokemonRemoteEntity> pokemonList = new ArrayList<>();
        String[] nameList = {"Salamèche", "Carapuce",
                "Pikachu", "Psykokwak",
                "Leviator", "Magicarp",
                "Aspicot", "Dracofeu",
                "Lugia", "Palkia"};

        for(int i = 0; i < LIST_SIZE; i++) {
            pokemonList.add(new PokemonRemoteEntity(i, IMAGE_URL, nameList[i]));
        }

        this.pokemonList = pokemonList;

        return pokemonList;
    }
}
