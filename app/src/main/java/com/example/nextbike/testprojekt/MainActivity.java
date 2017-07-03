package com.example.nextbike.testprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button1 = null;
    Button button2 = null;
    Button button3 = null;
    Button button4 = null;
    Button button5 = null;
    Button button6 = null;
    Button button7 = null;
    Button button8 = null;
    Button button9 = null;
    Button button0 = null;
    Button buttonDelete = null;

    String numberVar = "";
    TextView showNumber = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Button> buttonList = new ArrayList<Button>();
        buttonList.add(button1 = (Button) findViewById(R.id.button4));
        buttonList.add(button2 = (Button) findViewById(R.id.button3));
        buttonList.add(button3 = (Button) findViewById(R.id.button7));
        buttonList.add(button4 = (Button) findViewById(R.id.button2));
        buttonList.add(button5 = (Button) findViewById(R.id.button5));
        buttonList.add(button6 = (Button) findViewById(R.id.button6));
        buttonList.add(button7 = (Button) findViewById(R.id.button9));
        buttonList.add(button8 = (Button) findViewById(R.id.button8));
        buttonList.add(button9 = (Button) findViewById(R.id.button10));
        buttonList.add(button0 = (Button) findViewById(R.id.button12));

        for (final Button button : buttonList) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = String.valueOf(button.getText());
                    // die Länge der eingegebenen Nummer soll begrent werden (auf 15 Ziffern)
                    if (numberVar.length() <= 14) {
                        numberVar += buttonText;
                        showNumber.setText(numberVar);
                    }
                }
            });
        }


        buttonDelete = (Button) findViewById(R.id.button11);

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
                // check, ob ueberhaupt etwas in numberVar steht, wenn ja dann entferne den letzten char
                if (numberVar.length() > 0) {
                    numberVar = numberVar.substring(0, numberVar.length() - 1);
                }
                showNumber.setText(numberVar);
            }
        });




    }


}
