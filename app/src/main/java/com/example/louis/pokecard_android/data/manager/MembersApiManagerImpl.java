package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.data.entity.Pokemon;
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

    @Override
    public Observable<List<Member>> getMembers() {
        return null;
    }

    @Override
    public Observable<Member> getMember(int id) {
        return null;
    }
}
