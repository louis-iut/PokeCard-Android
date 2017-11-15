package com.example.louis.pokecard_android.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.presentation.listener.MemberListClickListener;
import com.example.louis.pokecard_android.presentation.viewholder.MemberListViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iem on 14/11/2017.
 */

public class MemberListAdapter  extends RecyclerView.Adapter<MemberListViewHolder> {

    private List<Member> memberList;
    private Context context;
    private MemberListClickListener memberListClickListener;

    public MemberListAdapter(Context context, MemberListClickListener memberListClickListener) {
        this.memberList = new ArrayList<>();
        this.context = context;
        this.memberListClickListener = memberListClickListener;
    }

    @Override
    public MemberListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_member, parent, false);
        return new MemberListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberListViewHolder holder, int position) {
        Member member = memberList.get(position);
        holder.bind(context, member, memberListClickListener);
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public void updateList(List<Member> memberList) {
        this.memberList = memberList;
        notifyDataSetChanged();
    }
}
