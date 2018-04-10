package com.example.mostafa.therealfoursquare;

import android.location.Location;

/**
 * Created by mostafa on 4/10/18.
 */

public interface Repository extends PlacesSubject{
    void getPlacesFromNetworkIfAvailable(Location location);
}
