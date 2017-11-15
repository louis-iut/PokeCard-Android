package com.example.louis.pokecard_android.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.listener.LoginClickListener;
import com.example.louis.pokecard_android.presentation.view.LoginView;
import com.facebook.login.widget.LoginButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iem on 15/11/2017.
 */

public class LoginFragment extends Fragment implements LoginClickListener, LoginView {

    @BindView(R.id.login_facebook_button) LoginButton loginButton;

    private View view;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClickOnFacebookLogin() {

    }

    @Override
    public void snackbarNoConnexion() {
        Toast toast = Toast.makeText(getActivity(), "No connexion", Toast.LENGTH_SHORT);
        toast.show();
    }
}
