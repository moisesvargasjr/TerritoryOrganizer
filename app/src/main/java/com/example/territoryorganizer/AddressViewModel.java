package com.example.territoryorganizer;

/*This is the ViewModel that contains all the data queried to the database. This is what interacts
with the Repository class and is the first layer that initiates the queries needed to make the activity UI work*/

import android.app.Application;

import com.google.android.gms.common.util.MurmurHash3;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AddressViewModel extends AndroidViewModel {
    private TerritoryRepository repository;
    private LiveData<List<Address_Entity>> addressList;

    public AddressViewModel (Application application) {
        super(application);
        repository = new TerritoryRepository(application);
        addressList = repository.getmAllAddresses();
    }

    //This is the LiveData object that contains all the addresses that the
    //RecyclerView adapater will use
    LiveData<List<Address_Entity>> getAddressList() { return addressList; }

    public void findAddressList(int territory_id) {
        repository.queryAddresseses(new Integer(territory_id));
    }

    public void insertAddress(Address_Entity address) {
        repository.insertAddress(address);
    }

}
