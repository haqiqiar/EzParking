package com.menanga.ezparking.server;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.menanga.ezparking.R;

import java.util.ArrayList;

public class SFindActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<LatLng> daftar;
    private LatLng my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfind);
        daftar = new ArrayList<LatLng>();
        //daftar.add(new LatLng(-7.277950, 112.796932));
        //daftar.add(new LatLng(-7.6, 112.79632));
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {


        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }



        googleMap.setMyLocationEnabled(true);

        // Getting LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        //locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,(long) 0, (float)100, this);
        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, false);

        Location location = locationManager.getLastKnownLocation(provider);
        // Getting Current Location

        if (location != null) {
            // Getting latitude of the current location
            double latitude = location.getLatitude();

            // Getting longitude of the current location
            double longitude = location.getLongitude();

            // Creating a LatLng object for the current location
            LatLng latLng = new LatLng(latitude, longitude);
            Toast.makeText(getApplicationContext(), latLng.toString(), Toast.LENGTH_SHORT).show();
            LatLng myPosition = new LatLng(latitude, longitude);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

            // Zoom in the Google Map
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(14));
            googleMap.addMarker(new MarkerOptions().position(myPosition).title("You are here!").snippet("Consider yourself located"));
            //googleMap.addMarker(new MarkerOptions().position(myPosition).title("Start"));

        }

/*
        // Show the current location in Google Map

*/
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.detail_loc, null);

                LatLng latLng = marker.getPosition();

                //TextView tvLat = (TextView) v.findViewById(R.id.mlokasi);

                //tvLat.setText(latLng.latitude + " " + latLng.longitude);

                return v;
            }
        });

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                //mMap.clear();

                //MarkerOptions mO = new MarkerOptions();

                //mO.position(latLng);
                if(daftar.contains(latLng)){
                    //LatLng a = new LatLng(latLng.latitude+0.4, latLng.longitude+0.54353);
                    //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(a,15));

                    //mMap.animateCamera(CameraUpdateFactory.newLatLng(a));

                }


                //Marker marker = mMap.addMarker(mO);

                //marker.showInfoWindow();
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Projection projection = mMap.getProjection();

                LatLng markerLatLng = new LatLng(marker.getPosition().latitude,
                        marker.getPosition().longitude);
                Point markerScreenPosition = projection.toScreenLocation(markerLatLng);
                Point pointHalfScreenAbove = new Point(markerScreenPosition.x,
                        markerScreenPosition.y -  300);

                LatLng aboveMarkerLatLng = projection
                        .fromScreenLocation(pointHalfScreenAbove);

                marker.showInfoWindow();
                CameraUpdate center = CameraUpdateFactory.newLatLng(aboveMarkerLatLng);
                mMap.moveCamera(center);
                return true;
            }
        });

        for(LatLng pos : daftar){

            mMap.addMarker(new MarkerOptions().position(pos).title("Marker in Sydney"));

            //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(my.getLatitude(), my.getLongitude()),15));
            // Zoom in, animating the camera.
            //googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            //googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        }
        // Add a marker in Sydney and move the camera

        //LatLng ssydney = new LatLng(-34, 152);



        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //mMap.addMarker(new MarkerOptions().position(ssydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ssydney));
    }

}
