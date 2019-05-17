package com.example.territoryorganizer;

/*Interface that allows the Repository class to make queries to the local SQL database*/

import com.example.territoryorganizer.Territory_Entity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TerritoryDao {

    @Insert
    void insertTerritory(Territory_Entity territory);

    @Insert
    void insertAddress(Address_Entity address);

    @Query("DELETE FROM territory_table")
    void deleteAllTerritory();

    @Query("DELETE FROM address_table")
    void deleteAllAddresses();

    @Query("SELECT * from territory_table ORDER BY Territory_ID ASC")
    LiveData<List<Territory_Entity>> getAllTerritories();

    @Query("SELECT * from address_table WHERE Territory_Assigned = :territoryAssigned")
    List<Address_Entity> getAllAddresses(int territoryAssigned);

    @Query("Select * from address_table")
    LiveData<List<Address_Entity>> get2AllAddresses();
}
