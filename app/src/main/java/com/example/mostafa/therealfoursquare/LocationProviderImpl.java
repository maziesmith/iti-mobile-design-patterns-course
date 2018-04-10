package com.example.mostafa.therealfoursquare;

import android.location.Location;

/**
 * Created by mostafa on 4/10/18.
 */

public class LocationProviderImpl implements LocationProvider{
     public Location getFakeLastKnowLocation() {
        Location location = new Location("Fake Location");
        location.setLatitude(100D);
        location.setLongitude(100D);
        return location;
    }

}
