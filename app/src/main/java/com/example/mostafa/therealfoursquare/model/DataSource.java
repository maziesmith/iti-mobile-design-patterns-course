package com.example.mostafa.therealfoursquare.model;

import android.location.Location;

import com.example.mostafa.therealfoursquare.PlacesObserver;

/**
 * Created by mostafa on 4/10/18.
 */

public interface DataSource {
    void getPlaces(Location location, PlacesObserver placesObserver);

}
