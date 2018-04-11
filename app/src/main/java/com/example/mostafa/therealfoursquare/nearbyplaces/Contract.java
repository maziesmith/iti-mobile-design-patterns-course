package com.example.mostafa.therealfoursquare.nearbyplaces;

import com.example.mostafa.therealfoursquare.model.Place;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mostafa on 4/11/18.
 */

public interface Contract {



    interface PlacesView {
        void updateUI(List<Place> places);
    }

    interface PlacesPresenter {
        void refreshData();
    }
}
