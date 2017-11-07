package com.example.louis.pokecard_android.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.louis.pokecard_android.PokeCardApp;
import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;
import com.example.louis.pokecard_android.presentation.adapter.PokemonListAdapter;
import com.example.louis.pokecard_android.presentation.listener.PokemonListClickListener;
import com.example.louis.pokecard_android.presentation.presenter.PokemonListPresenter;
import com.example.louis.pokecard_android.presentation.view.PokemonListView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by louis on 18/10/2017.
 */

public class PokemonListFragment extends Fragment implements PokemonListView, PokemonListClickListener{

    private PokemonListPresenter pokemonListPresenter;
    private PokemonListAdapter pokemonListAdapter;
    private View view;

    @BindView(R.id.swipe_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.pokemon_recycler_view) RecyclerView recyclerView;

    public static PokemonListFragment newInstance() {
        Bundle args = new Bundle();

        PokemonListFragment fragment = new PokemonListFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initPresenter();
        initRecyclerView();
        initSwipeRefresh();
    }

    private void initPresenter() {
        pokemonListPresenter = new PokemonListPresenter(
                PokeCardApp.getInstance().getRepository(),
                (PokemonNavigatorListener) getActivity()
        );
    }

    private void initRecyclerView() {
        pokemonListAdapter = new PokemonListAdapter(getActivity(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(pokemonListAdapter);
    }

    private void initSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pokemonListPresenter.getPokemonListFromApi();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void updateList(List<Pokemon> pokemonList) {
        //pokemonListAdapter;
    }

    @Override
    public void sncakbarNoConnexion() {

    }
}
