package com.example.louis.pokecard_android.presentation.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.data.entity.Member;
import com.example.louis.pokecard_android.presentation.listener.MemberListClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iem on 14/11/2017.
 */

public class MemberListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_member_firstname) TextView memberFirstname;

    private View itemView;

    public MemberListViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Context context, final Member member, final MemberListClickListener memberListClickListener) {
        memberFirstname.setText(member.getFirstName());
        //setBackgroundColor(context, getAdapterPosition());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memberListClickListener.onClickOnMemberList(member.getId());
            }
        });
    }

    public void setBackgroundColor(Context context, int position) {

       /* int color = (position %2 == 0)
                ? ContextCompat.getColor(context, R.color.colorGrey)
                : ContextCompat.getColor(context, R.color.colorDarkGrey);

        itemView.setBackgroundColor(color);*/
    }
}
