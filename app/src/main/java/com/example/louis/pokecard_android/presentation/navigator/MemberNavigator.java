package com.example.louis.pokecard_android.presentation.navigator;

import android.app.Fragment;
import android.app.FragmentManager;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.fragment.MemberDetailFragment;
import com.example.louis.pokecard_android.presentation.fragment.MemberListFragment;
import com.example.louis.pokecard_android.presentation.view.MemberDetailView;
import com.example.louis.pokecard_android.presentation.view.MemberListView;

/**
 * Created by iem on 14/11/2017.
 */

public class MemberNavigator {

    private FragmentManager fragmentManager;

    private final static int MEMBER_LIST_FRAGMENT = 0;
    private final static int MEMBER_DETAIL_FRAGMENT = 1;
    private int currentFragment;

    public MemberNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void launchMemberListFragment() {
        MemberListView memberListView = MemberListFragment.newInstance();

        fragmentManager
                .beginTransaction()
                .addToBackStack("memberListView")
                .add(R.id.frame_layout, (Fragment) memberListView)
                .commit();

        currentFragment = MEMBER_LIST_FRAGMENT;
    }

    public void launchDetailFragment(int id) {
        MemberDetailView memberDetailView = MemberDetailFragment.newInstance(id);

        fragmentManager
                .beginTransaction()
                .addToBackStack("memberDetailView")
                .replace(R.id.frame_layout, (Fragment) memberDetailView)
                .commit();

        currentFragment = MEMBER_DETAIL_FRAGMENT;
    }

    public void backAction() {
        if (currentFragment == MEMBER_DETAIL_FRAGMENT) {
            fragmentManager.popBackStack();
            currentFragment = MEMBER_LIST_FRAGMENT;
        }
    }

    /*public void shareAction(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(intent,"Share via"));
    }*/
}
