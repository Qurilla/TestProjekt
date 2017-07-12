package com.example.nextbike.testprojekt;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Locale;

public class MenuActivity extends CountDownBase {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TimerRestart();

        // Zum Anpassen der Sprache:
        String languageToLoad = FirstActivity.selectedLanguage;
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        //config.locale = locale;     DEPRECATED, deswegen stattdessen die Zeile hier drunter
        config.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        //Context newContext = createConfigurationContext(config);
        //attachBaseContext(newContext);


        setContentView(R.layout.activity_menu);
    }


    public void startNummereingabe (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }

    public void showMoreInfo (View view) {
        Intent intent = new Intent(this, MoreInfoActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }



}
