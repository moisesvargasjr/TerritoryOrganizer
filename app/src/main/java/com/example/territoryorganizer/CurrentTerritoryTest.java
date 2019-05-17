package com.example.territoryorganizer;

/*This was a test activity that tried to do what CurrentTerritoryBeta does except it does
* try to query the database. Has been unsuccesful so far*/

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CurrentTerritoryTest extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private MyAddressRecyclerViewAdapter myAdapter;
    private AddressViewModel mAddressViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_territory_test);
        mAddressViewModel = ViewModelProviders.of(this).get(AddressViewModel.class);

        mAddressViewModel.getAddressList().observe(this, new Observer<List<Address_Entity>>() {
            @Override
            public void onChanged(List<Address_Entity> address_entities) {
                myAdapter.setmAddresses(address_entities);
            }
        });

        mRecycleView = findViewById(R.id.addressRecyclerView);
        myAdapter = new MyAddressRecyclerViewAdapter(this);
        mRecycleView.setAdapter(myAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}
