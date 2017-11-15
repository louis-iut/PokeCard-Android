package com.example.louis.pokecard_android.presentation.presenter;

import com.example.louis.pokecard_android.data.Repository;
import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.presentation.listener.MemberNavigatorListener;
import com.example.louis.pokecard_android.presentation.view.MemberDetailView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by iem on 14/11/2017.
 */

public class MemberDetailPresenter {


    private Repository repository;
    private MemberDetailView memberDetailView;
    private MemberNavigatorListener memberNavigatorListener;

    public MemberDetailPresenter(Repository repository, MemberNavigatorListener memberNavigatorListener) {
        this.repository = repository;
        this.memberNavigatorListener = memberNavigatorListener;
    }

    public void setMemberDetailView(MemberDetailView memberDetailView) {
        this.memberDetailView = memberDetailView;
    }

    public void getMember(int id) {
        observe(repository.getMember(id));
    }

    private void observe(Observable<Member> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Member>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        memberDetailView.snackbarNoConnexion();
                    }

                    @Override
                    public void onNext(Member member) {
                        memberDetailView.updateUI(member);
                    }
                });
    }

    public void backAction() {
        memberNavigatorListener.onBackPressed();
    }
}
