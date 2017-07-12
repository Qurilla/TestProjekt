package com.example.nextbike.testprojekt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BikeCountFragment extends Fragment {

    public static BikeCountFragment newInstance() {
        return new BikeCountFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_bike_count, container, false);

    }




}
