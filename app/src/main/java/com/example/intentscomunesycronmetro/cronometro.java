package com.example.intentscomunesycronmetro;


import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class cronometro extends AppCompatActivity {
    private Button BotonArranque;
    private Button Pausa;
    private Button reinicio;
    private Chronometer crono;

    private long lastPause;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cronometro);
        BotonArranque = (Button) findViewById(R.id.start_button);
        Pausa = (Button) findViewById(R.id.pause_button);
        reinicio = (Button) findViewById(R.id.reset_button);
        crono = (Chronometer) findViewById(R.id.chronometer);

        BotonArranque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastPause != 0) {
                    crono.setBase(crono.getBase() + SystemClock.elapsedRealtime() - lastPause);
                } else {
                    crono.setBase(SystemClock.elapsedRealtime());
                }

                crono.start();
                BotonArranque.setEnabled(false);
                Pausa.setEnabled(true);
            }
        });

        Pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastPause = SystemClock.elapsedRealtime();
                crono.stop();
                Pausa.setEnabled(false);
                BotonArranque.setEnabled(true);
            }
        });

        reinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crono.stop();
                crono.setBase(SystemClock.elapsedRealtime());
                lastPause = 0;
                BotonArranque.setEnabled(true);
                Pausa.setEnabled(false);
            }
        });

        //Volver al main
        Button volver=(Button) findViewById(R.id.button);
        volver.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent comunication = new Intent(v.getContext(), MainActivity.class);
                startActivity(comunication);

            }
        });
    }
}


