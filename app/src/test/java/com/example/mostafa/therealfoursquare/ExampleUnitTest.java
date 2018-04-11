package com.example.mostafa.therealfoursquare;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.mostafa.therealfoursquare.model.Place;
import com.example.mostafa.therealfoursquare.model.Repository;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testViewModel() throws Exception{
            Repository mockRepo = mock(Repository.class);
//            when(mockRepo.getPlacesFromNetworkIfAvailable(new Location("AAAA"))).thenReturn()
            mockRepo.getPlacesFromNetworkIfAvailable(new Location("AAA"));
            PlacesViewModel vm = new PlacesViewModel();

        Observer<List<Place>> observer = new Observer<List<Place>>() {
            @Override
            public void onChanged(@Nullable List<Place> places) {

            }
        };
        vm.getPlacesStream().observeForever(observer);
            verify(observer).onChanged(new ArrayList<Place>());
    }
}