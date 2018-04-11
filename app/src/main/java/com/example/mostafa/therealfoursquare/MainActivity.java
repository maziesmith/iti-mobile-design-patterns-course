package com.example.mostafa.therealfoursquare;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.mostafa.therealfoursquare.model.Place;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    public static final String TAG = "FourSquare";
    private PlacesViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.textView);

        viewmodel = ViewModelProviders.of(this).get(PlacesViewModel.class);
        bindViewModel();
    }

    private void bindViewModel() {
        viewmodel.getPlacesStream().observe(this, new Observer<List<Place>>() {
            @Override
            public void onChanged(@Nullable List<Place> places) {
                updateUI(places);
            }
        });
    }

    void updateUI(List<Place> places) {
        //Update UI
        textView.setText("Success");
    }

}
