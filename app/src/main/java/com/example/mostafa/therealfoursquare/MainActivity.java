package com.example.mostafa.therealfoursquare;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mostafa.therealfoursquare.model.Place;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity implements PlacesObserver {

    TextView textView;

    // TODO: Use Dagger to inject dependencies
//    LocationProvider locationProvider;
//    NetworkApi networkApi;

    Repository repository;

    public static final String TAG = "FourSquare";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.textView);

        LocationProvider locationProvider = new LocationProviderImpl();
        Location lastKonwLocation = locationProvider.getFakeLastKnowLocation();
        getPlaces(lastKonwLocation);

    }

    private void getPlaces(Location lastKonwLocation) {
        NetworkApi networkApi = new NetworkApiImpl();
        LocalDataSource localDataSource = new LocalDataSource();
        Repository repository = new RepositoryImpl(networkApi, localDataSource);

        repository.getPlacesFromNetworkIfAvailable(lastKonwLocation);
        repository.registerObserver(this);

    }

    void updateUI(List<Place> places) {
        //Update UI
        textView.setText("Success");
    }

    @Override
    public void onPlacesAvailable(List<Place> places) {
        updateUI(places);
    }
}
