package com.example.territoryorganizer;

//Assigned Territory activity will call a RecyclerView adapater to create the UI used on this app

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AssignedTerritories extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private TerritoryListAdapter mAdapter;
    private TerritoryViewModel mTerritoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigned_territories);
        mTerritoryViewModel = ViewModelProviders.of(this).get(TerritoryViewModel.class);

        mTerritoryViewModel.getAllTerritories().observe(this, new Observer<List<Territory_Entity>>() {
            @Override
            public void onChanged(List<Territory_Entity> territory_entities) {
                mAdapter.setTerritories(territory_entities);
            }
        });

        mRecycleView = findViewById(R.id.territoryRecyclerView);

        mAdapter = new TerritoryListAdapter(this);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));


    }
}
