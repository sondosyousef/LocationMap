package com.example.mapmap;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ArrayList<LatLng> arrayList = new ArrayList<>();
    LatLng Nablus = new LatLng(32.2211, 35.2544);
    LatLng Sebastia =new LatLng(33.2, 35.2);
    LatLng  MaqamJoseph  =new LatLng(33.2, 35.2);
    LatLng  JacobWell   =new LatLng(-32.052700, 117.217350);
    LatLng  MountGerizim  =new LatLng(33.2, 35.2);
    LatLng oldCity  =new LatLng(32.3, 35.3);
    LatLng KhanTraders =new LatLng(32.2, 35.2);
    LatLng HadiPalace =new LatLng(32.2, 35.2);
    LatLng LighthouseClock =new LatLng(32.4, 35.3);
    LatLng NasrMosque =new LatLng(32.2, 35.2);
    LatLng SabanaTouqan =new LatLng(32.2, 35.2);
    LatLng Turkishbaths =new LatLng(32.2, 35.2);

    ArrayList<String> title = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // ADD item in array
        arrayList.add(Nablus);
        arrayList.add(Sebastia);
        arrayList.add(MaqamJoseph);
        arrayList.add(JacobWell);
        arrayList.add(MountGerizim);
        arrayList.add(oldCity);
        arrayList.add(KhanTraders);
        arrayList.add(HadiPalace);
        arrayList.add(LighthouseClock);
        arrayList.add(NasrMosque);
        arrayList.add(SabanaTouqan);
        arrayList.add(Turkishbaths);

        title.add("Nablus");
        title.add("Sebastia");
        title.add("Jacob's Well");
        title.add("Maqam Joseph");
        title.add("Mount Gerizim");
        title.add("old City");
        title.add("Khan Traders");
        title.add("Abdul Hadi Palace");
        title.add("Lighthouse Clock");
        title.add("Nasr Mosque");
        title.add("Sabana Touqan");
        title.add("Turkish baths");








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




        for (int i = 0; i < arrayList.size(); i++) {

            for (int j = 0; j < title.size(); j++) {

                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(i))));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arrayList.get(i),10));

        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();
                Intent intent = new Intent(MapsActivity.this,DetailActivity.class);
                intent.putExtra("title",markerTitle);
                startActivity(intent);
                return false;
            }
        });


    }
}