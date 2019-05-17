package com.example.territoryorganizer;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class CurrentTerritory extends FragmentActivity implements OnMapReadyCallback, AddressFragment.OnListFragmentInteractionListener {

    private static final String TAG = "Current Territory"; 
    
    private GoogleMap mMap;
    private Territory territory;
    private ArrayList<LatLng> addressList = new ArrayList<>();
    private double latitude[] = new double [25];
    private double longitude[] = new double [25];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_territory);

        territory = new Territory(72,"Poway","Mira Mesa");

        Log.i(TAG, "onCreate: territoty object created");

        territory.insertFakeListings();

        GeocodingLocation locationAddress = new GeocodingLocation();
        locationAddress.getAddressFromLocation(territory,getApplicationContext(), new GeocoderHandler(this));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    private class GeocoderHandler extends Handler {
        private final WeakReference<CurrentTerritory> mAcctivity;

        public GeocoderHandler(CurrentTerritory activity) {
            mAcctivity = new WeakReference<CurrentTerritory>(activity);
        }

        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    latitude = bundle.getDoubleArray("latitude");
                    longitude = bundle.getDoubleArray("longitude");
                    for (int i = 0; i < territory.listingList.size(); i++) {
                        addressList.add(new LatLng(latitude[i], longitude[i]));
                    }
                    Log.d(TAG, "handleMessage: address list has been populated");
                    break;

                default:
            }

        }

    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    /*This is the original CurrentTerritory activity that did not make it into the final
    * Demo. This creates the map fragment and calls the addresslist freagment so the two
    * fragments can be shown together*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (int i = 0; i<addressList.size();i++) {
            mMap.addMarker(new MarkerOptions().position(addressList.get(i)).title(Integer.toString(i)));
            Log.d(TAG, "onMapReady: Map has been called");
        }
    }

    public void addGoogleMapAddresses() {


        mMap.moveCamera(CameraUpdateFactory.newLatLng(addressList.get(0)));
    }

    @Override
    public void onListFragmentInteraction(Listing address) {

    }

//    private class populateAddressListAsyncTask extends AsyncTask<Void,Void,Void> {
//        WeakReference<Context> mContext;
//
//        populateAddressListAsyncTask(Context context) {
//            this.mContext = context;
//        }
//
//        @Override
//        protected Void
//    }
}
