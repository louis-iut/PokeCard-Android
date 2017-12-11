package com.example.louis.pokecard_android.presentation.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.PokemonRemoteEntity;
import com.example.louis.pokecard_android.presentation.listener.PokemonListClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by louis on 18/10/2017.
 */

public class PokemonListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_pokemon_image) ImageView pokemonImage;
    @BindView(R.id.item_pokemon_name) TextView pokemonName;

    private View itemView;

    public PokemonListViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Context context, final PokemonRemoteEntity pokemon, final PokemonListClickListener pokemonListClickListener) {
        Picasso.with(context).load(pokemon.getImage()).into(pokemonImage);
        pokemonName.setText(pokemon.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokemonListClickListener.onClickOnPokemonList(pokemon.getId());
            }
        });
    }
}
