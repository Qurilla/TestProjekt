package com.example.nextbike.testprojekt;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public abstract class CountDownBase extends AppCompatActivity {

    public final static int COUNT_DOWN_TIME = 30000;

    public static CountDownTimer cTimer;


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //int action = MotionEventCompat.getActionMasked(event); // DEPRECATED
        int action = event.getAction();
        int buttonAction = event.getActionMasked();

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                TimerRestart();
                return true;
            default:

                return super.onTouchEvent(event);
        }
    }



    public void TimerRestart(){
        //CountDown zurücksetzen
        cTimer.cancel();
        cTimer.start();
    }



    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Zurück zur SprachauswahlActivity, wenn Zeit abgelaufen ist
        if (cTimer == null) {
            cTimer = new CountDownTimer(COUNT_DOWN_TIME, 1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    backToFirstScreen();
                }

            }.start();
        }
    }



    public void backToFirstScreen () {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
        TimerRestart();
    }
}
