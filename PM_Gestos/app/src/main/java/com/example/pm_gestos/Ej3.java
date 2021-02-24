package com.example.pm_gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class Ej3 extends AppCompatActivity {

    public View v1, v2, v3;
    GestureDetectorCompat mDetector;
    public View touched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3);
        v1 = findViewById(R.id.ej3_v1);
        v2 = findViewById(R.id.ej3_v2);
        v3 = findViewById(R.id.ej3_v3);

        mDetector = new GestureDetectorCompat(this, new Ej3.BorGestos());
        v1.setOnTouchListener(touchListener);
        v2.setOnTouchListener(touchListener);
    }

    View.OnTouchListener touchListener = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            touched = v;
            return mDetector.onTouchEvent(event);
        }
    };

    class BorGestos extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(touched == v1){
                v3.setBackgroundColor(Color.RED);
            }
            return true;
        }


        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if(touched == v2){
                v3.setBackgroundColor(Color.BLUE);
            }
            return true;
        }
    }
}