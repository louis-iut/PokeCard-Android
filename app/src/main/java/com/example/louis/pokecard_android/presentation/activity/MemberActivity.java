package com.example.louis.pokecard_android.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.listener.MemberNavigatorListener;
import com.example.louis.pokecard_android.presentation.navigator.MemberNavigator;
import com.example.louis.pokecard_android.presentation.navigator.PokemonNavigator;

public class MemberActivity extends AppCompatActivity implements MemberNavigatorListener {

    private MemberNavigator memberNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        memberNavigator = new MemberNavigator(getFragmentManager());
        memberNavigator.launchMemberListFragment();
    }

    @Override
    public void displayMemberDetail(int id) {
        memberNavigator.launchDetailFragment(id);
    }

    @Override
    public void displayMemberList() {
        memberNavigator.launchMemberListFragment();
    }

    @Override
    public void shareAction(String url) {
    }

    @Override
    public void onBackPressed() {
        memberNavigator.backAction();
    }
}
