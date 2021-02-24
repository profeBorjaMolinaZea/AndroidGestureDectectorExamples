package com.example.pm_gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class Ej1 extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    GestureDetectorCompat mDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);
        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }



    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        MainActivity.mensaje(this, "Tap simple que no forma parte de uno doble");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        MainActivity.mensaje(this, "Doble tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        MainActivity.mensaje(this, "Double tap. Detectado al pulsar, al levantar el dedo y durante cualquier movimiento durante el segundo tap");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //mensaje(this, "Pones el dedo en la pantalla");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        //mensaje(this, "El usuario toca la pantalla, no levanta el dedo ni hace scroll. Util feedback visual");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        MainActivity.mensaje(this, "Levantas el dedo un un single tap");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        MainActivity.mensaje(this, "Se ejecuta durante el scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        MainActivity.mensaje(this, "Haces una pulsación larga");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        MainActivity.mensaje(this, "Deslizas el dedo");
        return true;
    }
}