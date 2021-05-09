package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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
        LatLng masjid = new LatLng(-0.8334607,119.6164239);
        LatLng rumahku = new LatLng(-0.834643,119.615825);
        // Custom size marker
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_hitam) ;
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pin_map_merah) ;
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false) ;

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(masjid).title("Marker in Masjid")
                .snippet("Ini Adalah Masjid")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(rumahku).title("Marker in Rumahku")
                .snippet("Ini Adalah Rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(masjid,  11.5f));

        mMap.addMarker(new MarkerOptions().position(masjid).title("Marker in Masjid")
                .snippet("Ini Adalah Masjid")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(rumahku).title("Marker in Rumahku")
                .snippet("Ini Adalah Rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));
        mMap.addPolyline(new PolylineOptions().add(
                masjid,
                new LatLng(-0.834643, 119.615825),
                new LatLng(-0.834463, 119.615934),
                new LatLng(-0.834324, 119.616052),
                new LatLng(-0.834217, 119.616117),
                new LatLng(-0.834066, 119.616170),
                new LatLng(-0.833884, 119.616267),
                new LatLng(-0.833798, 119.616395),
                new LatLng(-0.833680, 119.616460),
                new LatLng(-0.8334607, 119.6164239),
                rumahku
        ).width(10)
                .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rumahku, 14.5f));
    }
}
