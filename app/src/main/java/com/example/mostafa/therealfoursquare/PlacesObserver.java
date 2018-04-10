package com.example.mostafa.therealfoursquare;

import com.example.mostafa.therealfoursquare.model.Place;

import java.util.List;

/**
 * Created by mostafa on 4/10/18.
 */

public interface PlacesObserver {
    public void onPlacesAvailable(List<Place> places);
}
