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
import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.presentation.listener.MemberNavigatorListener;
import com.example.louis.pokecard_android.presentation.presenter.MemberDetailPresenter;
import com.example.louis.pokecard_android.presentation.view.MemberDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iem on 14/11/2017.
 */

public class MemberDetailFragment extends Fragment implements MemberDetailView {

    private static final String MEMBER_ID_KEY = "com.example.louis.pokecard_android.presentation.fragment.MemberDetailFragment.MEMBER_ID_KEY";
    private MemberDetailPresenter memberDetailPresenter;

    @BindView(R.id.fragment_member_detail_firstname) TextView memberFirstname;

    public static MemberDetailFragment newInstance(int id) {
        MemberDetailFragment fragment = new MemberDetailFragment();
        Bundle args = new Bundle();

        args.putInt(MEMBER_ID_KEY, id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member_detail, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    @Override
    public void updateUI(Member member) {
        memberFirstname.setText(member.getFirstName());

    }

    private void initPresenter() {
        this.memberDetailPresenter = new MemberDetailPresenter(PokeCardApp.getInstance().getRepository(), (MemberNavigatorListener) getActivity());
        memberDetailPresenter.setMemberDetailView(this);

        if(getArguments() != null && getArguments().containsKey(MEMBER_ID_KEY)) {
            memberDetailPresenter.getMember(getArguments().getInt(MEMBER_ID_KEY));
        }
    }

    @Override
    public void snackbarNoConnexion() {

    }
}
