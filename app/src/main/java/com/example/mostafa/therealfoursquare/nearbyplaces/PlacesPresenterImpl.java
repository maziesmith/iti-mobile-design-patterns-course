package com.example.mostafa.therealfoursquare.nearbyplaces;

import android.content.Context;
import android.location.Location;

import com.example.mostafa.therealfoursquare.LocalDataSource;
import com.example.mostafa.therealfoursquare.LocationProvider;
import com.example.mostafa.therealfoursquare.LocationProviderImpl;
import com.example.mostafa.therealfoursquare.NetworkApiImpl;
import com.example.mostafa.therealfoursquare.PlacesObserver;
import com.example.mostafa.therealfoursquare.RepositoryImpl;
import com.example.mostafa.therealfoursquare.model.Place;
import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by mostafa on 4/11/18.
 */

public class PlacesPresenterImpl implements Contract.PlacesPresenter{

    private final NetworkApiImpl networkApi;
    private final LocalDataSource localDataSource;
    private final RepositoryImpl repository;
    private final LocationProviderImpl locationProvider;
    private final Contract.PlacesView view;

    public PlacesPresenterImpl(Contract.PlacesView view){
        networkApi = new NetworkApiImpl();
        localDataSource = new LocalDataSource();
        repository = new RepositoryImpl(networkApi, localDataSource);
        locationProvider = new LocationProviderImpl();
        this.view = view;
    }

    @Override
    public void refreshData() {
        Location lastKonwLocation = locationProvider.getFakeLastKnowLocation();
        repository.getPlacesFromNetworkIfAvailable(lastKonwLocation);
        repository.registerObserver(new PlacesObserver() {
            @Override
            public void onPlacesAvailable(List<Place> places) {
                view.updateUI(places);
            }
        });
    }
}
