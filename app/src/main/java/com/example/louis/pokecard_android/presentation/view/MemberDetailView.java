package com.example.louis.pokecard_android.presentation.view;

import com.example.louis.pokecard_android.data.entity.Member;

/**
 * Created by iem on 14/11/2017.
 */

public interface MemberDetailView {

    void updateUI(Member member);
    void snackbarNoConnexion();
}
