package com.example.mostafa.therealfoursquare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mostafa.therealfoursquare.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mostafa on 4/10/18.
 */

public class NetworkApiImpl implements NetworkApi {

    private final static String TAG = "NetworkApiImpl";


    @Override
    public void getPlaces(Location location, final PlacesObserver placesObserver) {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Location, Integer, List<Place>> asyncTask = new AsyncTask<Location, Integer, List<Place>>() {
            @Override
            protected List<Place> doInBackground(Location... locations) {
                Log.v(TAG, "Network Request");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.v(TAG, "Network Response");

                return generateFakePlacesList();
            }

            @Override
            protected void onPostExecute(List<Place> places) {
                super.onPostExecute(places);
//                context.updateUI(places);
                placesObserver.onPlacesAvailable(places);
            }

            private List<Place> generateFakePlacesList() {

                ArrayList<Place> places = new ArrayList<>();
                places.add(new Place());
                places.add(new Place());
                places.add(new Place());
                return  places;
            }
        };
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, location);
    }
}
