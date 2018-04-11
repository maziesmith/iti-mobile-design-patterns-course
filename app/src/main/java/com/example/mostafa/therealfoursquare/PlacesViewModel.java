package com.example.mostafa.therealfoursquare;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.location.Location;

import com.example.mostafa.therealfoursquare.model.LocalDataSource;
import com.example.mostafa.therealfoursquare.model.NetworkApi;
import com.example.mostafa.therealfoursquare.model.NetworkApiImpl;
import com.example.mostafa.therealfoursquare.model.Place;
import com.example.mostafa.therealfoursquare.model.RepositoryImpl;

import java.util.List;

/**
 * Created by mostafa on 4/10/18.
 */

public class PlacesViewModel extends ViewModel {

    private final RepositoryImpl repository;
    private MutableLiveData<List<Place>> placesStream = new MutableLiveData<>();

    LiveData<List<Place>> getPlacesStream(){
        return placesStream;
    }

    //TODO Injection
    public PlacesViewModel(){
        LocationProvider locationProvider = new LocationProviderImpl();
        Location lastKnowLocation = locationProvider.getFakeLastKnowLocation();

        NetworkApi networkApi = new NetworkApiImpl();
        LocalDataSource localDataSource = new LocalDataSource();
        repository = new RepositoryImpl(networkApi, localDataSource);

        updateLastKnowLocation(lastKnowLocation);
    }

    void updateLastKnowLocation(Location location) {
        repository.registerObserver(new PlacesObserver() {
            @Override
            public void onPlacesAvailable(List<Place> places) {
                placesStream.setValue(places);
            }
        });
        repository.getPlacesFromNetworkIfAvailable(location);
    }

}
