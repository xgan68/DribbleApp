package com.example.alexx.dribbleapp.view.shot_list;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexx.dribbleapp.R;
import com.example.alexx.dribbleapp.view.base.ShotListDecoration;

import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by alexx on 9/28/2017.
 */



public class ShotListFragment extends Fragment {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    public static ShotListFragment newInstance() {
        return new ShotListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new ShotListDecoration(
                getResources().getDimensionPixelSize(R.dimen.spacing_medium)));
        ShotListAdapter adapter = new ShotListAdapter();
        recyclerView.setAdapter(adapter);
    }
}
