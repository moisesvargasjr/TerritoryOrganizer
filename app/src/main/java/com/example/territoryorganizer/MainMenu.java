package com.example.territoryorganizer;

/*The main menu is a simple activity that has several CardViews that open up other activities*/

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        CardView currentTerritory = findViewById(R.id.current_territory);
        currentTerritory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentTerritoryIntent = new Intent(MainMenu.this, CurrentTerritoryBeta.class);
                startActivity(currentTerritoryIntent);
            }
        });

        CardView mapTerritory = findViewById(R.id.mapTerritory);
        mapTerritory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent assignedTerritoriesIntent = new Intent(MainMenu.this, MapsActivity.class);
                startActivity(assignedTerritoriesIntent);
            }
        });

        CardView assignedTerritories = findViewById(R.id.assigned_territories);
        assignedTerritories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent assignedTerritoriesIntent = new Intent(MainMenu.this, AssignedTerritories.class);
                startActivity(assignedTerritoriesIntent);
            }
        });

        CardView profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent profileIntent = new Intent(MainMenu.this, PublisherProfile.class);
                startActivity(profileIntent);
            }
        });
    }


}
