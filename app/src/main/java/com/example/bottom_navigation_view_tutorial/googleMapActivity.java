package com.example.bottom_navigation_view_tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.ArrayList;
import java.util.List;

public class googleMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    Button searchLocationBtn;
    EditText loactionEdtTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapId);
        mapFragment.getMapAsync(this);


        searchLocationBtn = findViewById(R.id.searchLocationBtn);
        loactionEdtTxt = findViewById(R.id.locationEdtTxt);

        //initialize places
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyDuv6IWc3SayzPtyY7o26-BHXosZw2QESw");
        }

        // Initialize PlacesClient
        PlacesClient placesClient = Places.createClient(this);

        searchLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = loactionEdtTxt.getText().toString().trim();
//                performSearch(placesClient, location);
            }
        });
    }

//    private void performSearch(PlacesClient placesClient, String query) {
//        List<Place.Field> placeFields = new ArrayList<>();
//        placeFields.add(Place.Field.LAT_LNG);
//
//        FindCurrentPlaceRequest request = FindCurrentPlaceRequest.newInstance(placeFields);
//
////        FindCurrentPlaceRequest request = FindCurrentPlaceRequest.newInstance(query);
//
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        placesClient.findCurrentPlace(request).addOnSuccessListener((response) -> {
////            for (FindCurrentPlaceResponse.PlaceLikelihood placeLikelihood : response.getPlaceLikelihoods()) {
////                LatLng location = placeLikelihood.getPlace().getLatLng();
////                if (location != null) {
////                    // Move the camera to the searched location
////                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
////                }
////            }
//            List<PlaceLikelihood>placeLikelihoods = new ArrayList<>() ;
//
//            FindCurrentPlaceResponse findCurrentPlaceResponse = FindCurrentPlaceResponse.newInstance(placeLikelihoods) ;
//
//        }).addOnFailureListener((exception) -> {
//            // Handle the error, e.g., display a message to the user
//        });
//    }

    @Override
    public void onMapReady(@NonNull GoogleMap gMap) {
        googleMap = gMap ;

    }
}