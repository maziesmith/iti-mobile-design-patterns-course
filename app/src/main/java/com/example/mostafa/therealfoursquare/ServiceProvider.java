package com.example.mostafa.therealfoursquare;

import com.example.mostafa.therealfoursquare.model.LocalDataSource;
import com.example.mostafa.therealfoursquare.model.NetworkApi;
import com.example.mostafa.therealfoursquare.model.Repository;
import com.example.mostafa.therealfoursquare.model.RepositoryImpl;

/**
 * Created by mostafa on 4/11/18.
 */

public class ServiceProvider {
    private static NetworkApi networkApi;
    private static LocalDataSource localDataSource;
    private static Repository repository;
    private static LocationProvider locationProvider;

//    public NetworkApi provideRepository() {
//        if (repository == null) {
//            repository = new RepositoryImpl()
//        }
//    }

}
