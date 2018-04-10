package com.example.mostafa.therealfoursquare;

import android.location.Location;

/**
 * Created by mostafa on 4/10/18.
 */

public interface DataSource {
    void getPlaces(Location location, PlacesObserver placesObserver);

}
