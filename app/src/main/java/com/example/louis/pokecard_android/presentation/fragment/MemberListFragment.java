package com.example.louis.pokecard_android.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.louis.pokecard_android.PokeCardApp;
import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.presentation.adapter.MemberListAdapter;
import com.example.louis.pokecard_android.presentation.adapter.PokemonListAdapter;
import com.example.louis.pokecard_android.presentation.listener.MemberListClickListener;
import com.example.louis.pokecard_android.presentation.listener.MemberNavigatorListener;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;
import com.example.louis.pokecard_android.presentation.presenter.MemberListPresenter;
import com.example.louis.pokecard_android.presentation.presenter.PokemonListPresenter;
import com.example.louis.pokecard_android.presentation.view.MemberListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iem on 14/11/2017.
 */

public class MemberListFragment extends Fragment implements MemberListView, MemberListClickListener {

    private MemberListPresenter memberListPresenter;
    private MemberListAdapter memberListAdapter;
    private View view;

    @BindView(R.id.swipe_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.member_recycler_view) RecyclerView recyclerView;


    public static MemberListFragment newInstance() {
        MemberListFragment fragment = new MemberListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_member_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPresenter();
        initRecyclerView();
        initSwipeRefresh();
    }

    private void initPresenter() {
        memberListPresenter = new MemberListPresenter(
                PokeCardApp.getInstance().getRepository(),
                (MemberNavigatorListener) getActivity()
        );

        memberListPresenter.setMemberListView(this);
        memberListPresenter.getMemberList();
    }

    private void initRecyclerView() {
        memberListAdapter = new MemberListAdapter(getActivity(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(memberListAdapter);
    }

    private void initSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                memberListPresenter.getMemberList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void updateList(List<Member> memberList) {
        memberListAdapter.updateList(memberList);
    }

    @Override
    public void snackbarNoConnexion() {
        Toast toast = Toast.makeText(getActivity(), "No connexion", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClickOnMemberList(int id) {
        memberListPresenter.onClickOnMembersList(id);
    }
}

