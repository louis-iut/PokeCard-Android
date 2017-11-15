package com.example.louis.pokecard_android.presentation.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.louis.pokecard_android.PokeCardApp;
import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.Pokemon;
import com.example.louis.pokecard_android.presentation.listener.PokemonNavigatorListener;
import com.example.louis.pokecard_android.presentation.presenter.PokemonDetailPresenter;
import com.example.louis.pokecard_android.presentation.view.PokemonDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by louis on 12/11/2017.
 */

public class PokemonDetailFragment extends Fragment implements PokemonDetailView {

    private static final String POKEMON_ID_KEY = "com.example.louis.pokecard_android.presentation.fragment.PokemonDetailFragment.POKEMON_ID_KEY";
    private PokemonDetailPresenter pokemonDetailPresenter;

    @BindView(R.id.fragment_pokemon_detail_name) TextView pokemonName;
    /*@BindView(R.id.detail_date) TextView dateView;
    @BindView(R.id.detail_image)
    ImageView imageView;
    @BindView(R.id.detail_code) TextView diamondCodeView;
    @BindView(R.id.detail_creators) TextView creatorsView;
    @BindView(R.id.detail_url) TextView urlView;
    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;*/

    public static PokemonDetailFragment newInstance(int id) {
        PokemonDetailFragment fragment = new PokemonDetailFragment();
        Bundle args = new Bundle();

        args.putInt(POKEMON_ID_KEY, id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_detail, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    @Override
    public void updateUI(Pokemon pokemon) {
        pokemonName.setText(pokemon.getName());
       /* titleView.setText(comicsViewModel.getComicsEntity().getTitle());
        diamondCodeView.setText(getResources().getString(R.string.diamond_code) + comicsViewModel.getComicsEntity().getDiamondCode());
        dateView.setText(getResources().getString(R.string.date) + comicsViewModel.getDate());
        creatorsView.setText(comicsViewModel.getCreators());
        urlOfComics = comicsViewModel.getComicsEntity().getUrl();

        String url = "<a href='"
                + urlOfComics
                + "'>"
                + getResources().getString(R.string.link_tag)
                + "</a>";
        urlView.setText(Html.fromHtml(url));
        urlView.setMovementMethod(LinkMovementMethod.getInstance());

        Picasso.with(getActivity()).load(comicsViewModel.getComicsEntity().getImage()).into(imageView);*/
    }

    private void initPresenter() {
        this.pokemonDetailPresenter = new PokemonDetailPresenter(PokeCardApp.getInstance().getRepository(), (PokemonNavigatorListener) getActivity());
        pokemonDetailPresenter.setPokemonDetailView(this);

        if(getArguments() != null && getArguments().containsKey(POKEMON_ID_KEY)) {
            pokemonDetailPresenter.getPokemon(getArguments().getInt(POKEMON_ID_KEY));
        }
    }

    /*@OnClick(R.id.comics_detail_back_button)
    public void onToolbarBackButtonClick() {
        pokemonDetailPresenter.backAction();
    }*/

    /*@OnClick(R.id.comics_detail_share_button)
    public void onToolbarShareButtonClick() {
        pokemonDetailPresenter.shareAction(urlOfComics);
    }*/

    @Override
    public void snackbarNoConnexion() {

    }
}
