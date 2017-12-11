package com.example.louis.pokecard_android.presentation.presenter;

import com.example.louis.pokecard_android.data.repository.Repository;
import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.presentation.listener.MemberNavigatorListener;
import com.example.louis.pokecard_android.presentation.view.MemberListView;


import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by louis on 18/10/2017.
 */

public class MemberListPresenter {

    private Repository repository;
    private MemberListView memberListView;
    private MemberNavigatorListener memberNavigatorListener;

    public MemberListPresenter(Repository repository, MemberNavigatorListener memberNavigatorListener) {
        this.repository = repository;
        this.memberNavigatorListener = memberNavigatorListener;
    }

    public void setMemberListView(MemberListView memberListView) {
        this.memberListView = memberListView;
    }

    public void getMemberList() {
        observe(repository.getMembers());
    }

    private void observe(Observable<List<Member>> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Member>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        memberListView.snackbarNoConnexion();
                    }

                    @Override
                    public void onNext(List<Member> memberList) {
                        memberListView.updateList(memberList);
                    }
                });
    }

    public void onClickOnMembersList(int id) {
        memberNavigatorListener.displayMemberDetail(id);
    }
}
