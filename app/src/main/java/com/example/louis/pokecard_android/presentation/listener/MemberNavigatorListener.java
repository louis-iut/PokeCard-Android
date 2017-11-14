package com.example.louis.pokecard_android.presentation.listener;

/**
 * Created by iem on 14/11/2017.
 */

public interface MemberNavigatorListener {
    void displayMemberDetail(int id);
    void displayMemberList();
    void onBackPressed();
    void shareAction(String url);
}
