package com.example.louis.pokecard_android.presentation.view;

import com.example.louis.pokecard_android.data.entity.Member;

import java.util.List;

/**
 * Created by iem on 14/11/2017.
 */

public interface MemberListView {

    void updateList(List<Member> memberList);
    void snackbarNoConnexion();
}
