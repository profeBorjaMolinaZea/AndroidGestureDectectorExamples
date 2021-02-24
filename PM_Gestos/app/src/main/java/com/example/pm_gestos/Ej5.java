package com.example.pm_gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Ej5 extends AppCompatActivity {

    Button b, bV;
    TextView t, t2, tVictoria;
    long time1, time2, diff;
    long limiteVictoria = 500;
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej5);
        b = (Button)findViewById(R.id.ej5_b);
        bV = (Button)findViewById(R.id.ej5_bV);
        t = (TextView)findViewById(R.id.ej5_t);
        t2 = (TextView)findViewById(R.id.ej5_t2);
        tVictoria = (TextView)findViewById(R.id.ej5_tVictoria);
        b.setOnTouchListener(touchListener);

        turno();
    }

    View.OnTouchListener touchListener = new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                time1 = SystemClock.elapsedRealtime();
            }
            else if(event.getAction() == MotionEvent.ACTION_UP){
                time2 = SystemClock.elapsedRealtime();
                diff = time2-time1;
                t2.setText(Long.toString(diff));
                comprobarVictoria();
                bV.setVisibility(View.VISIBLE);
                //MainActivity.mensaje(getApplicationContext(), Long.toString(diff));
            }
            return true;
        }
    };

    public void iniciarCrono(final int duration){
        int sensibilidad = 10;
        new CountDownTimer(duration, sensibilidad) {
            public void onTick(long millisUntilFinished) {
                t.setText(Integer.toString(duration-(int)millisUntilFinished));
            }

            public void onFinish() {
                t.setText(Integer.toString(duration));
            }
        }.start();
    }

    public void turno(){
        Random ran = new Random();
        duration = 2000+ran.nextInt(3000);
        iniciarCrono(duration);
        t2.setText("");
        tVictoria.setVisibility(View.INVISIBLE);
        bV.setVisibility(View.INVISIBLE);
    }

    public boolean comprobarVictoria(){
        boolean hasGanado = false;
        if(Math.abs(duration-diff)<limiteVictoria){
            hasGanado = true;
            tVictoria.setText("Titán, leyenda!");
            tVictoria.setTextColor(Color.GREEN);
        }
        else{
            tVictoria.setText("No esperaba nada y aún así me has decepcionado");
            tVictoria.setTextColor(Color.RED);
        }
        tVictoria.setVisibility(View.VISIBLE);
        return hasGanado;
    }

    public void clickNuevoTurno(View v){
        turno();
    }
}