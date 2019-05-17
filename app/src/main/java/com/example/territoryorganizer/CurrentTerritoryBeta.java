package com.example.territoryorganizer;

/*This is the activity that is shown in the current activity demo
* It is a placeholder that shows how the address list would be shown in a single
* activity. Addresses are currently hardcoded and not being referenced from the database*/

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

public class CurrentTerritoryBeta extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[][]myDataset = {
            {"10267","Black Mountain Rd","M7","5/03/18"},
            {"10273","Black Mountain Rd","L1","5/10/18"},
            {"10771","Black Mountain Rd","2","5/07/18"},
            {"9494","Caroll Canyon Rd","11","5/09/18"},
            {"9504","Caroll Canyon Rd","201","5/15/18"},

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_territory_beta);
        recyclerView = (RecyclerView) findViewById(R.id.betaRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(myDataset,this);
        recyclerView.setAdapter(mAdapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
