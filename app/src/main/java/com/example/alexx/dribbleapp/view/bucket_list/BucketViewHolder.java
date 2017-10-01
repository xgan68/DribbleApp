package com.example.alexx.dribbleapp.view.bucket_list;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexx.dribbleapp.R;
import com.example.alexx.dribbleapp.view.base.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by alexx on 9/30/2017.
 */

public class BucketViewHolder extends BaseViewHolder {

    public BucketViewHolder(View itemView) {
        super(itemView);
    }

    @BindView(R.id.bucket_name) public TextView bucketName;
    @BindView(R.id.bucket_shot_count) public TextView bucketShotCount;
    @BindView(R.id.bucket_shot_chosen) public ImageView bucketShotChosen;

}
