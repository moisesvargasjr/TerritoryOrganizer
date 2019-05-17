package com.example.territoryorganizer;

/*
* The Room database instantioation. It also populates the database with some sample data*/

import android.content.Context;
import android.os.AsyncTask;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Territory_Entity.class,Address_Entity.class},version = 2)
public abstract class TerritoryRoomDatabase extends RoomDatabase {
    public abstract TerritoryDao territoryDao();

    private static volatile TerritoryRoomDatabase INSTANCE;

    static TerritoryRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TerritoryRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),TerritoryRoomDatabase.class,"territory_database").fallbackToDestructiveMigration().addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);

                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

   private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {

        private final TerritoryDao mDao;

        PopulateDbAsync(TerritoryRoomDatabase db) {
            mDao = db.territoryDao();
        }

        @Override
       protected Void doInBackground(Void... params) {
            mDao.deleteAllTerritory();
            mDao.deleteAllAddresses();
            Territory_Entity territory = new Territory_Entity(72,"Poway","Mira Mesa","Undefined");
            mDao.insertTerritory(territory);
            territory = new Territory_Entity(46,"Poway","Torrey Hills","Moises Vargas");
            mDao.insertTerritory(territory);
            territory = new Territory_Entity(33,"Poway","Rancho Penasquitos", "Kenny Silva");
            mDao.insertTerritory(territory);
            Address_Entity address = new Address_Entity(01,"101","Main Street",
                    "San Diego","92064","D1","John Appleseed","none","Unknown",
                    "05/25/2018",72);
            return null;
        }
   }


}
