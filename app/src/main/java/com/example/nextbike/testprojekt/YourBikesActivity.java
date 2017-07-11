package com.example.nextbike.testprojekt;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class YourBikesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bikes);
    }


    // Zurück-zum-ersten-Screen-Button
    public void toAccountScreen (View view) {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }
}
