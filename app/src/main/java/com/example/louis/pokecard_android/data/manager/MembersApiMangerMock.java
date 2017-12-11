package com.example.louis.pokecard_android.data.manager;

import com.example.louis.pokecard_android.data.entity.Member;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * Created by iem on 14/11/2017.
 */

public class MembersApiMangerMock implements MembersApiManager {

    private final static int LIST_SIZE = 5;
    private List<Member> memberList;

    @Override
    public Observable<List<Member>> getMembers() {
        return Observable.defer(new Func0<Observable<List<Member>>>() {
            @Override
            public Observable<List<Member>> call() {
                return Observable.just(createMemberListMock());
            }
        });
    }

    @Override
    public Observable<Member> getMember(int id) {
        return Observable.just(memberList.get(id));
    }

    private List<Member> createMemberListMock() {
        List<Member> memberList = new ArrayList<>();
        String[] firstnameList = {"Jean", "Paul", "Louis", "Bernard", "Momo"};
        String[] lastnameList = {"Dupont", "Dupas", "Duko", "Dubo", "Dumoche"};
        String[] pseudoList = {"XXazerXX", "XXazerXX", "XXazerXX", "XXazerXX", "XXazerXX"};
        String[] emailList = {"Jean@gmail.fr", "Paul@gmail.fr", "Louis@gmail.fr", "Bernard@gmail.fr", "Momo@gmail.fr"};


        for(int i = 0; i < LIST_SIZE; i++) {
            memberList.add(new Member(i,firstnameList[i],lastnameList[i],pseudoList[i],emailList[i]));
        }

        this.memberList = memberList;

        return memberList;
    }
}
