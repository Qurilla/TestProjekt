package com.example.nextbike.testprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {


    public static String selectedLanguage = "en";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void startSecondScreen (View view) {
        this.selectedLanguage = "en";
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }

    public void startSecondScreenDE (View view) {
        this.selectedLanguage = "de";
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }
}
