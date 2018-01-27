package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.PokemonRemoteEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 18/10/2017.
 */

public class PokeApiManagerImpl implements PokeApiManager {

    private static final String BASE_URL = "http://192.168.43.181/index.php/";
    private PokemonApiIO pokemonApiIO;

    public interface PokemonApiIO {
        @GET("pokemons")
        Observable<List<PokemonRemoteEntity>> getPokedex(@Query("page") int page, @Query("number") int number);
    }

    public PokeApiManagerImpl() {

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        pokemonApiIO = retrofit.create(PokemonApiIO.class);
    }

    @Override
    public Observable<List<PokemonRemoteEntity>> getPokemonList(int page, int number) {
        return pokemonApiIO.getPokedex(page, number);
    }

    @Override
    public Observable<List<PokemonRemoteEntity>> getPokemonListOfUser(int userId) {
        return null;
    }

    @Override
    public Observable<PokemonRemoteEntity> getPokemon(int id) {
        return null;
    }
}
