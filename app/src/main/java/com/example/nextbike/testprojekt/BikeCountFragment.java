package com.example.nextbike.testprojekt;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class BikeCountFragment extends Fragment {


    public final static int MAX_BIKE_RENT_COUNT = 4;
    public final static int MIN_BIKE_RENT_COUNT = 1;
    public int bikeCountCount = 1;

    public TextView bikeCountNumber = null;

    public Button bikeCountMore = null;
    public Button bikeCountLess = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bike_count, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        bikeCountMore = getActivity().findViewById(R.id.bikeCountMore);
        bikeCountLess =  getActivity().findViewById(R.id.bikeCountLess);
        bikeCountNumber = getActivity().findViewById(R.id.bikeCountNumber);

        // um den Minus-Button von Beginn an auszugrauen, da ja nicht weniger als 1 Fahrrad moeglich ist:
        bikeCountLess.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        bikeCountMore.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                //TimerRestart();
                bikeCountLess.getBackground().setColorFilter(null);
                if (bikeCountCount < MAX_BIKE_RENT_COUNT) {
                    bikeCountCount += 1;
                    bikeCountNumber.setText(String.valueOf(bikeCountCount));
                    if (bikeCountCount == 4) {
                        bikeCountMore.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                    }
                } else {
                    //Toast.makeText(getApplicationContext(), "Maximum reached", Toast.LENGTH_SHORT).show();
                }
            }
        });


        bikeCountLess.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                //TimerRestart();
                bikeCountMore.getBackground().setColorFilter(null);
                if (bikeCountCount > MIN_BIKE_RENT_COUNT) {
                    bikeCountCount -= 1;
                    bikeCountNumber.setText(String.valueOf(bikeCountCount));
                    if (bikeCountCount == 1) {
                        bikeCountLess.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                    }
                } else {
                    //Toast.makeText(getApplicationContext(), "Minimum reached", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
