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

    private GoogleMap mMap,mm;


    ArrayList<LatLng> arrayList = new ArrayList<>();
    LatLng Nablus = new LatLng(32.2211, 35.2544);
    LatLng Sebastia =new LatLng(32.27647333353645, 35.197966041977494);
    LatLng  MaqamJoseph  =new LatLng(32.98266257486524, 35.49013604199582);
    LatLng  JacobWell   =new LatLng(32.2095198043856, 35.28528382365309);
    LatLng  MountGerizim  =new LatLng(32.1950011855653, 35.2641666633116);
    LatLng oldCity  =new LatLng(32.219627887985354, 35.26149790571429);
    LatLng KhanTraders =new LatLng(32.21994242430669, 35.26351422125106);
    LatLng HadiPalace =new LatLng(32.22423573313789, 35.26209870877827);
    LatLng LighthouseClock =new LatLng(32.21590147536036, 35.273750290930884);
    LatLng NasrMosque =new LatLng(32.21891310852186, 35.26169907305228);
    LatLng SabanaTouqan =new LatLng(32.21910978147422, 35.261180428486036);
    LatLng Turkishbaths =new LatLng(32.22485493566722, 35.23628566214025);

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

         mm= googleMap;
        LatLng myLocation = new LatLng(31.904945171998865, 35.20287782759413);
         mm.addMarker(new MarkerOptions().position(myLocation).title("my Location"));
         mm.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation,18f));


        for (int i = 0; i < arrayList.size(); i++) {

            for (int j = 0; j < title.size(); j++) {

                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(i))));

            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arrayList.get(i),12));

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