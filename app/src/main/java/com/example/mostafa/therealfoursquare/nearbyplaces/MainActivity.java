package com.example.mostafa.therealfoursquare.nearbyplaces;

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
import android.widget.Button;
import android.widget.TextView;

import com.example.mostafa.therealfoursquare.LocationProvider;
import com.example.mostafa.therealfoursquare.LocationProviderImpl;
import com.example.mostafa.therealfoursquare.PlacesObserver;
import com.example.mostafa.therealfoursquare.R;
import com.example.mostafa.therealfoursquare.Repository;
import com.example.mostafa.therealfoursquare.model.Place;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


public class MainActivity extends AppCompatActivity implements Contract.PlacesView {

    static int counter = 0;

    TextView textView;

    // TODO: Use Dagger to inject dependencies
    Contract.PlacesPresenter presenter;

    public static final String TAG = "FourSquare";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new PlacesPresenterImpl(this);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.refreshData();
    }

    public void updateUI(List<Place> places) {
        //Update UI
        textView.setText("Success");
    }


}
