package com.example.pm_gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class Ej2 extends AppCompatActivity {

    GestureDetectorCompat mDetector;
    View parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);
        parentView = findViewById(R.id.parentEj2);
        mDetector = new GestureDetectorCompat(this, new BorGestos());
        parentView.setOnTouchListener(touchListener);
    }

    View.OnTouchListener touchListener = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return mDetector.onTouchEvent(event);
        }
    };

    class BorGestos extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            //long eventDuration = e.getEventTime() - e.getDownTime();
            MainActivity.mensaje(getApplicationContext(), "pulsación larga");
        }
    }
}