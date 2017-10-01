package com.example.alexx.dribbleapp.view.bucket_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexx.dribbleapp.R;
import com.example.alexx.dribbleapp.model.Bucket;
import com.example.alexx.dribbleapp.view.base.ShotListDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexx on 9/30/2017.
 */

public class BucketListFragment extends Fragment {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;


    public BucketListFragment newInstance() {
        return new BucketListFragment();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new ShotListDecoration(
                getResources().getDimensionPixelSize(R.dimen.spacing_medium)));

        BucketListAdapter adapter = new BucketListAdapter(fakeData());

        recyclerView.setAdapter(adapter);
    }

    private List<Bucket> fakeData() {
        List<Bucket> bucketList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; ++i) {
            Bucket bucket = new Bucket();
            bucket.name = "Bucket" + i;
            bucket.shots_count = random.nextInt(10);
            bucketList.add(bucket);
        }
        return bucketList;
    }
}
