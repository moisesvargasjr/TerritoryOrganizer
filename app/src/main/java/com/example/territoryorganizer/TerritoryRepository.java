package com.example.territoryorganizer;

/*Abstract layer between the view model and the Room layer. This will handle logic
* deciding whether to query external database or internal one*/

import android.app.Application;
import android.os.AsyncTask;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class TerritoryRepository {
    private TerritoryDao mTerritoryDao;
    private LiveData<List<Territory_Entity>> mAllTerritories;
    private LiveData<List<Address_Entity>> mAllAddresses;
    private MutableLiveData<List<Address_Entity>> addressQueryResults = new MutableLiveData<>();
    private LiveData<List<Address_Entity>> allAddresses;

    TerritoryRepository(Application application) {
        TerritoryRoomDatabase db = TerritoryRoomDatabase.getDatabase(application);
        mTerritoryDao = db.territoryDao();
        mAllTerritories = mTerritoryDao.getAllTerritories();
        mAllAddresses = mTerritoryDao.get2AllAddresses();
    }

    LiveData<List<Territory_Entity>> getmAllTerritories() {
        return mAllTerritories;
    }

    LiveData<List<Address_Entity>> getmAllAddresses() { return mAllAddresses;}

    MutableLiveData<List<Address_Entity>> getAddressQueryResults() { return addressQueryResults;}

    public void insertTerritory (Territory_Entity territory) {
        new insertTerritoriesAsyncTask(mTerritoryDao).execute(territory);
    }

    public void queryAddresseses (Integer assigned_territory) {
        new queryAddressesAsyncTask(mTerritoryDao).execute(assigned_territory);
    }

    public void insertAddress (Address_Entity address) {
        new insertAddressAsyncTask(mTerritoryDao).execute(address);
    }

    private static class insertTerritoriesAsyncTask extends AsyncTask<Territory_Entity, Void, Void> {

        private TerritoryDao mAsyncTaskDao;

        insertTerritoriesAsyncTask(TerritoryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Territory_Entity... params) {
            mAsyncTaskDao.insertTerritory(params[0]);
            return null;
        }
    }

    private static class queryAddressesAsyncTask extends AsyncTask<Integer, Void, List<Address_Entity>> {
        private TerritoryDao asyncTaskDao;
        private TerritoryRepository delegate = null;

        queryAddressesAsyncTask(TerritoryDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected List<Address_Entity> doInBackground(final Integer... params) {
            return asyncTaskDao.getAllAddresses(params[0]);
        }

        @Override
        protected void onPostExecute (List<Address_Entity> result) {
            delegate.asyncFinished(result);
        }
    }

    private void asyncFinished (List<Address_Entity> results) {
        addressQueryResults.setValue(results);
    }

    private static class insertAddressAsyncTask extends AsyncTask<Address_Entity,Void,Void> {
        private TerritoryDao asyncTaskDao;

        insertAddressAsyncTask(TerritoryDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Address_Entity... params){
            asyncTaskDao.insertAddress(params[0]);
            return null;
        }
    }
}
