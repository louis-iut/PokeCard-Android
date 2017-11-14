package com.example.louis.pokecard_android.presentation.viewholder;

<<<<<<< Updated upstream
=======
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.presentation.listener.PokemonListClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

>>>>>>> Stashed changes
/**
 * Created by louis on 18/10/2017.
 */

<<<<<<< Updated upstream
public class PokemonListViewHolder {
=======
public class PokemonListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_pokemon_image) ImageView pokemonImage;
    @BindView(R.id.item_pokemon_name) TextView pokemonName;
    private View itemView;

    public PokemonListViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Context context, final Pokemon pokemon, final PokemonListClickListener pokemonListClickListener) {
        Picasso.with(context).load(pokemon.getImage()).into(pokemonImage);
        pokemonName.setText(pokemon.getName());
        //setBackgroundColor(context, getAdapterPosition());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokemonListClickListener.onClickOnPokemonList(pokemon.getId());
            }
        });
    }

    public void setBackgroundColor(Context context, int position) {

       /* int color = (position %2 == 0)
                ? ContextCompat.getColor(context, R.color.colorGrey)
                : ContextCompat.getColor(context, R.color.colorDarkGrey);

        itemView.setBackgroundColor(color);*/
    }
>>>>>>> Stashed changes
}
