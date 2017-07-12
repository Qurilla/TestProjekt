package com.example.nextbike.testprojekt;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AccountActivity extends CountDownBase {


    public final static int MAX_BIKE_RENT_COUNT = 4;
    public final static int MIN_BIKE_RENT_COUNT = 1;
    public int bikeCountCount = 1;

    TextView bikeCountNumber = null;

    Button bikeCountMore = null;
    Button bikeCountLess = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        TimerRestart();


            bikeCountMore = (Button) findViewById(R.id.bikeCountMore);
        bikeCountLess = (Button) findViewById(R.id.bikeCountLess);
        bikeCountNumber = (TextView) findViewById(R.id.bikeCountNumber);
        bikeCountLess.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);


        bikeCountMore.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                TimerRestart();
                bikeCountLess.getBackground().setColorFilter(null);
                if (bikeCountCount < MAX_BIKE_RENT_COUNT) {
                    bikeCountCount += 1;
                    bikeCountNumber.setText(String.valueOf(bikeCountCount));
                    if (bikeCountCount == 4) {
                        bikeCountMore.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Maximum reached", Toast.LENGTH_SHORT).show();
                }
            }
        });


        bikeCountLess.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                TimerRestart();
                bikeCountMore.getBackground().setColorFilter(null);
                if (bikeCountCount > MIN_BIKE_RENT_COUNT) {
                    bikeCountCount -= 1;
                    bikeCountNumber.setText(String.valueOf(bikeCountCount));
                    if (bikeCountCount == 1) {
                        bikeCountLess.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Minimum reached", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void rentNew (View view) {
        Intent intent = new Intent(this, BikeCountActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }

    public void logOut (View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }



}
