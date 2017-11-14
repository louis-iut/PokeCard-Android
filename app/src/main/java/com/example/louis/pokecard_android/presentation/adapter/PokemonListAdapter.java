package com.example.louis.pokecard_android.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.presentation.listener.PokemonListClickListener;
import com.example.louis.pokecard_android.presentation.viewholder.PokemonListViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louis on 18/10/2017.
 */

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListViewHolder>{

    private List<Pokemon> pokemonList;
    private Context context;
    private PokemonListClickListener pokemonListClickListener;

    public PokemonListAdapter(Context context, PokemonListClickListener pokemonListClickListener) {
        this.pokemonList = new ArrayList<>();
        this.context = context;
        this.pokemonListClickListener = pokemonListClickListener;
    }

    @Override
    public PokemonListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pokemon, parent, false);
        return new PokemonListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonListViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.bind(context, pokemon, pokemonListClickListener);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void updateList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }
}
