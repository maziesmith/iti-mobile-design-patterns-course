package com.example.mostafa.therealfoursquare;

import com.example.mostafa.therealfoursquare.model.Place;

import java.util.List;

/**
 * Created by mostafa on 4/10/18.
 */

public interface PlacesSubject {
    void registerObserver(PlacesObserver placesObserver);
    void notifyObservers(List<Place> places);
    void unRegisterObserver(PlacesObserver placesObserver);
}
