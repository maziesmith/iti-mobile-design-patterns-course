package com.example.mostafa.therealfoursquare.model;

/**
 * Created by mostafa on 4/10/18.
 */

public class Place {
    public int id;

    public Place(){

    }

    public Place(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((Place)obj).id;
    }
}
