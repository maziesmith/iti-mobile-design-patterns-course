package com.example.mostafa.therealfoursquare.model;

import android.location.Location;

import com.example.mostafa.therealfoursquare.PlacesSubject;

/**
 * Created by mostafa on 4/10/18.
 */

public interface Repository extends PlacesSubject {
    void getPlacesFromNetworkIfAvailable(Location location);
}
