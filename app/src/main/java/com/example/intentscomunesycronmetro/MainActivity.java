package com.example.intentscomunesycronmetro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //muestra el navegador
        Button botoncito = (Button) findViewById(R.id.web);
        botoncito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.palomafp.org";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        //Encviar email
        Button boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, "ies.lapaloma.madrid@educa.madrid.org");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "email");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Buenos dias Virgen de la paloma");
                startActivity(Intent.createChooser(emailIntent, "Enviando"));
            }


        });
        //Boton de: llamada
        Button boton3 = (Button) findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vis) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:913980300")));

            }


        });
        //Boton de: mapa
        Button boton4 = (Button) findViewById(R.id.button4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.es/maps/place/IES+Virgen+de+la+Paloma/@40.4593002,-3.7188225,17z/data=!4m5!3m4!1s0xd4229b123b4d615:0x7d68ccc162207d2b!8m2!3d40.4593002!4d-3.7174304!5m1!1e4"));
                startActivity(intent);
            }


        });
        //Abrir camara
        Button boton10 = (Button) findViewById(R.id.button10);
        boton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 1);
                }else{
                    Toast.makeText(getApplicationContext(), "No se ha detectado camara", Toast.LENGTH_LONG).show();
                    Log.d("1", "No hay camara");
                }


            }


        });
        //Mostrar agenda
        Button boton9 = (Button) findViewById(R.id.button9);
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
            }


        });
        //Mostrar cronometro

        Button boton11 = (Button) findViewById(R.id.button11);
        boton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comunication = new Intent(v.getContext(), cronometro.class);
                startActivity(comunication);
            }


        });
    }
}
