package com.example.louis.pokecard_android.data.manager;

import android.content.Context;
import android.util.Log;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.UserRemoteEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 11/12/2017.
 */

public class LoginApiManagerImpl implements LoginApiManager {

    private static final String BASE_URL = "http://192.168.43.181/index.php/";
    private LoginApiIO loginApiIO;

    public interface LoginApiIO {
        @POST("login")
        Observable<UserRemoteEntity> loginRequest(@Body UserRemoteEntity userRemoteEntity);
    }

    public LoginApiManagerImpl(final Context context) {
        final OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i(context.getString(R.string.retrofit_log), message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client.addInterceptor(loggingInterceptor);

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        loginApiIO = retrofit.create(LoginApiIO.class);
    }

    @Override
    public Observable<UserRemoteEntity> loginRequest(String id, String password) {
        return loginApiIO.loginRequest(new UserRemoteEntity(id));
    }
}
