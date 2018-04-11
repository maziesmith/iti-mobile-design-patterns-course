package com.example.mostafa.therealfoursquare;

import android.location.Location;

import com.example.mostafa.therealfoursquare.model.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by mostafa on 4/10/18.
 */

public class RepositoryImpl implements Repository, PlacesSubject {

    private final DataSource networkApi;
    private final DataSource localDataSource;

    public RepositoryImpl(DataSource networkApi, DataSource localDataSource) {
        this.networkApi = networkApi;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getPlacesFromNetworkIfAvailable(Location location) {

        //Check Connection
        boolean isConnectionAvailable = true;

        if (isConnectionAvailable) {
            networkApi.getPlaces(location, new PlacesObserver() {
                @Override
                public void onPlacesAvailable(List<Place> places) {
                    notifyObservers(places);
                }
            });
            // And then cache the response locally
        } else {
            localDataSource.getPlaces(location, new PlacesObserver() {
                @Override
                public void onPlacesAvailable(List<Place> places) {

                }
            });
        }

    }

    List<PlacesObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(PlacesObserver placesObserver) {
        observers.add(placesObserver);
    }

    @Override
    public void notifyObservers(List<Place> places) {
        for (PlacesObserver observer: observers) {
            observer.onPlacesAvailable(places);
        }
    }

    @Override
    public void unRegisterObserver(PlacesObserver placesObserver) {
        observers.remove(placesObserver);
    }
}
