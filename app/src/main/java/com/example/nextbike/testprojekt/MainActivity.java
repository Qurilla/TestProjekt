package com.example.nextbike.testprojekt;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends CountDownBase {

    Button buttonDelete = null;
    Button buttonGo = null;

    // Zwischenspeicherung der eingegebenen Nummer
    String numberVar = "";
    //Anzeige der eingegebenen Nummer
    TextView showNumber = null;


    View.OnClickListener buttonNumberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TimerRestart();
            Button button = (Button) v;
            String buttonText = String.valueOf(button.getText());
            // die Länge der eingegebenen Nummer soll begrent werden (auf 15 Ziffern)
            if (numberVar.length() <= 14) {
                numberVar += buttonText;
                showNumber.setText(numberVar);
            }

        }
    };



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



        setContentView(R.layout.activity_main);


        List<Button> buttonList = Arrays.asList(
            (Button) findViewById(R.id.button4),
            (Button) findViewById(R.id.button3),
            (Button) findViewById(R.id.button7),
            (Button) findViewById(R.id.button2),
            (Button) findViewById(R.id.button5),
            (Button) findViewById(R.id.button6),
            (Button) findViewById(R.id.button9),
            (Button) findViewById(R.id.button8),
            (Button) findViewById(R.id.button10),
            (Button) findViewById(R.id.button12),
                (Button) findViewById(R.id.button13)
        );

        for (final Button button : buttonList) {
            button.setOnClickListener(buttonNumberClickListener);
        }


        buttonDelete = (Button) findViewById(R.id.button11);
        //buttonGo = (Button) findViewById(R.id.button13);
        showNumber = (TextView) findViewById(R.id.textView2);

// region buttons SpaghettiCode
/*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 1;
                showNumber.setText(numberVar);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 2;
                showNumber.setText(numberVar);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 3;
                showNumber.setText(numberVar);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 4;
                showNumber.setText(numberVar);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 5;
                showNumber.setText(numberVar);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 6;
                showNumber.setText(numberVar);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 7;
                showNumber.setText(numberVar);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 8;
                showNumber.setText(numberVar);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 9;
                showNumber.setText(numberVar);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberVar += 0;
                showNumber.setText(numberVar);
            }
        });
*/
// endregion



        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerRestart();
                // check, ob ueberhaupt etwas in numberVar steht, wenn ja dann entferne den letzten char
                if (numberVar.length() > 0) {
                    numberVar = numberVar.substring(0, numberVar.length() - 1);
                }
                showNumber.setText(numberVar);
            }
        });




    }

    // Zurück-zum-ersten-Screen-Button
    public void startFirstScreen (View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }

    public void startPinScreen (View view) {
        Intent intent = new Intent(this, PinActivity.class);
        intent.putExtra("UserNumber", numberVar);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }


}
