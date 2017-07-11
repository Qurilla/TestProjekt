package com.example.nextbike.testprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
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
