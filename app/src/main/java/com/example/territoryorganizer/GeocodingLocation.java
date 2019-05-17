package com.example.territoryorganizer;

/*This is a helper class that takes in a string parameter and outputs its lat long coordinates
* This method is applied from a separated AsyncTask*/
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeocodingLocation {

    private static final String TAG = "GeocodingLocation";

    public static void getAddressFromLocation(final Territory territory,
                                              final Context context, final Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                double[] latitude = new double[25];
                double[] longitude = new double[25];
                for (int i =0; i < territory.listingList.size(); i++){
                    Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                    Listing currentListing = territory.listingList.get(i);
                    String concatAddress =  currentListing.getStreetNumber() +
                                            currentListing.getStreetName() +
                                            currentListing.getCity() +
                                            currentListing.getState() +
                                            currentListing.getZipcode();

               try {
                   List<Address> addressList = geocoder.getFromLocationName(concatAddress, 1);
                   Address address = addressList.get(0);
                   latitude[i] = address.getLatitude();
                   longitude[i] = address.getLongitude();
               } catch (IOException e) {
                   Log.e(TAG,"Unable to connect to Geocoder",e);
               }
                }

                Message message = Message.obtain();
                message.setTarget(handler);
                Bundle bundle = new Bundle();
                bundle.putDoubleArray("latitude", latitude);
                bundle.putDoubleArray("longitude",longitude);
                message.setData(bundle);

                message.sendToTarget();
            }
        };
        thread.start();
    }
}
