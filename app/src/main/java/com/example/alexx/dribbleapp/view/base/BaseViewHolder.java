package com.example.alexx.dribbleapp.view.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by alexx on 9/28/2017.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
