package com.example.pm_gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class Ej4 extends AppCompatActivity {

    View parent;
    GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);
        parent = findViewById(R.id.ej4_parent);
        mDetector = new GestureDetectorCompat(this, new Ej4.BorGestos());
        parent.setOnTouchListener(touchListener);
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
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
           int mov = Ej4.BorDirection(e1.getX(), e1.getY(), e2.getX(), e2.getY());
           switch (mov){
               case 1:
                   parent.setBackgroundColor(Color.BLUE);
                   break;
               case 2:
                   parent.setBackgroundColor(Color.GREEN);
                   break;
               case 3:
                   parent.setBackgroundColor(Color.RED);
                   break;
               case 4:
                   parent.setBackgroundColor(Color.BLACK);
                   break;
           }
           return true;
        }
    }

    public static int BorDirection(float x1, float y1, float x2, float y2){
        int dir = 0;
        float diffX = x2-x1;
        float diffY = y2-y1;
        float absDiffX = Math.abs(diffX);
        float absDiffY = Math.abs(diffY);
        if(diffY<0 && absDiffY>absDiffX){
            dir = 1;
        }
        else if(diffX>0 && absDiffX>absDiffY){
            dir = 2;
        }
        else if(diffY>0 && absDiffY>absDiffX){
            dir = 3;
        }
        else if(diffX<0 && absDiffX>absDiffY){
            dir = 4;
        }
        return dir;
    }
}