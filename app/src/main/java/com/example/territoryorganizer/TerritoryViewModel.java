package com.example.territoryorganizer;

/*This is the ViewModel that contains all the data queried to the database. This is what interacts
with the Repository class and is the first layer that initiates the queries needed to make the activity UI work*/

import android.app.Application;
import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TerritoryViewModel extends AndroidViewModel {
    private TerritoryRepository mRepository;
    private LiveData<List<Territory_Entity>> mAllTerritories;

    public TerritoryViewModel (Application application) {
        super(application);
        mRepository = new TerritoryRepository(application);
        mAllTerritories = mRepository.getmAllTerritories();
    }

    LiveData<List<Territory_Entity>> getAllTerritories() { return mAllTerritories; }

    public void insert(Territory_Entity territory) { mRepository.insertTerritory(territory); }

}
