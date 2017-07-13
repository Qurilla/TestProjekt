package com.example.nextbike.testprojekt;

//import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentManager;



public class AccountActivity extends CountDownBase implements BikeCountFragment.OnOkayButtonListener {


    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    BikeCountFragment fragment = new BikeCountFragment();
    SuccessFragment fragmentSuccess = new SuccessFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        setContentView(R.layout.activity_account);


        TimerRestart();

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

    public void ChangeFragment () {

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragmentSuccess);
        fragmentTransaction.commit();
    }


    @Override
    public void OkayButtonClicked() {
        ChangeFragment();
    }
}
