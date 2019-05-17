package com.example.territoryorganizer;

/*The maps activity is a temporary activity that shows the Google Map implementation
* In the future, this is supposed to be a fragment that will be shown alongside Addresslist
* fragment in the CurrentTerritory activity. For now it serves its own activity with hard-coded
* latlong markers*/

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng marker1 = new LatLng(32.904529, -117.123210);
        LatLng marker2 = new LatLng(32.904295, -117.122923);
        LatLng marker3 = new LatLng(32.914869, -117.123667);
        LatLng marker4 = new LatLng(32.903150, -117.122319);
        LatLng marker5 = new LatLng(32.903286, -117.121442);

        mMap.addMarker(new MarkerOptions().position(marker1).title("10267 Black Mountain Rd"));
        mMap.addMarker(new MarkerOptions().position(marker2).title("10273 Black Mountain Rd"));
        mMap.addMarker(new MarkerOptions().position(marker3).title("10771 Black Mountain Rd"));
        mMap.addMarker(new MarkerOptions().position(marker4).title("9494 Caroll Canyon Rd"));
        mMap.addMarker(new MarkerOptions().position(marker5).title("9504 Caroll Canyon Rd"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(32.904529, -117.123210),15));
    }
}
