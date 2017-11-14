package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 18/10/2017.
 */

public class MembersApiManagerImpl implements MembersApiManager {

    public static final String URL = "https://pokeapi.co/api/v2/pokedex/";
    private APIEndpointUsersInterface apiEndpointUsersInterface;

    public MembersApiManagerImpl() {
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        apiEndpointUsersInterface = retrofit.create(APIEndpointUsersInterface.class);
    }

    @Override
    public Observable<List<Member>> getUsers() {
        return apiEndpointUsersInterface.getUsers().map(new Func1<List<Member>, List<Member>>() {
            @Override
            public List<Member> call(List<Member> members) {
                return members;
            }
        });
    }

    public interface APIEndpointUsersInterface {
        @GET("1")
        Observable<List<Member>> getUsers();
    }

}
