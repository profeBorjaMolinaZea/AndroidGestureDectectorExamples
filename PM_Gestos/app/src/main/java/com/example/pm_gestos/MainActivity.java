package com.example.pm_gestos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void mensaje(Context c, String msg){
        Toast.makeText(c, msg,Toast.LENGTH_SHORT).show();
    }

    public void irEjercicio(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.b1:
                intent = new Intent(this, Ej1.class);
                break;
            case R.id.b2:
                intent = new Intent(this, Ej2.class);
                break;
            case R.id.b3:
                intent = new Intent(this, Ej3.class);
                break;
            case R.id.b4:
                intent = new Intent(this, Ej4.class);
                break;
            case R.id.b5:
                intent = new Intent(this, Ej5.class);
                break;
            default:
                intent = new Intent(this, MainActivity.class);
                break;
        }
        startActivity(intent);
    }
}