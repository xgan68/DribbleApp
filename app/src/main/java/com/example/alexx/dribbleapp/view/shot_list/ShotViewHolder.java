package com.example.alexx.dribbleapp.view.shot_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexx.dribbleapp.view.base.BaseViewHolder;

import butterknife.BindView;
import com.example.alexx.dribbleapp.R;

/**
 * Created by alexx on 9/28/2017.
 */

public class ShotViewHolder extends BaseViewHolder{

    @BindView(R.id.shot_view_count) public TextView viewCount;
    @BindView(R.id.shot_like_count) public TextView likeCount;
    @BindView(R.id.shot_bucket_count) public TextView bucketCount;
    @BindView(R.id.shot_image) public ImageView image;

    public ShotViewHolder(View itemView ) {
        super(itemView);
    }
}
