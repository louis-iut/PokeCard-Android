package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.data.entity.PokemonRemoteEntity;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

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
