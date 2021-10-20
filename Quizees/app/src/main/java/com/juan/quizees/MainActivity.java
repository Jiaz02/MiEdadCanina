package com.juan.quizees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;
    private String Seleccion="";
    private boolean avanzar=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemClock.sleep(4000);

        if(respuestasCorrectas+respuestasIncorrectas!=0) {
            Bundle extras = getIntent().getExtras();
            respuestasCorrectas = extras.getInt("aciertos");
            System.out.println(respuestasCorrectas);
            respuestasIncorrectas = extras.getInt("errores");
            System.out.println(respuestasIncorrectas);
        }

        TextView idPregunta=findViewById(R.id.idNumPregunta);
        TextView pregunta = findViewById(R.id.idPregunta);

        RadioGroup rp = findViewById(R.id.RadioRespuesta);
        RadioButton rp1 = findViewById(R.id.radioButtonRespuesta1);
        RadioButton rp2 = findViewById(R.id.radioButtonRespuesta2);
        RadioButton rp3 = findViewById(R.id.radioButtonRespuesta3);

        Button btnSend = findViewById(R.id.buttonEnviar);

        String aux1=getResources().getString(R.string.Respuesta1);
        String aux2=getResources().getString(R.string.Respuesta2);
        String aux3=getResources().getString(R.string.Respuesta3);
        String aux4=getResources().getString(R.string.Pregunta);
        Pregunta p1= new Pregunta(1,aux4,aux1,aux2,aux3,aux3);
        preguntas.add(p1);

        aux1=getResources().getString(R.string.Respuesta4);
        aux2=getResources().getString(R.string.Respuesta5);
        aux3=getResources().getString(R.string.Respuesta6);
        aux4=getResources().getString(R.string.Pregunta2);
        Pregunta p2= new Pregunta(2,aux4,aux1,aux2,aux3,aux2);
        preguntas.add(p2);

        aux1=getResources().getString(R.string.Respuesta7);
        aux2=getResources().getString(R.string.Respuesta8);
        aux3=getResources().getString(R.string.Respuesta9);
        aux4=getResources().getString(R.string.Pregunta3);
        Pregunta p3= new Pregunta(3,aux4,aux1,aux2,aux3,aux1);
        preguntas.add(p3);

        switch (respuestasCorrectas+respuestasIncorrectas){
            case 0:
                idPregunta.setText(getResources().getString(R.string.NumPregunta));
                pregunta.setText(p1.getPregunta());
                rp1.setText(p1.getRespuesta1());
                rp2.setText(p1.getRespuesta2());
                rp3.setText(p1.getRespuesta3());
                break;
            case 1:
                idPregunta.setText(getResources().getString(R.string.NumPregunta2));
                pregunta.setText(p2.getPregunta());
                rp1.setText(p2.getRespuesta1());
                rp2.setText(p2.getRespuesta2());
                rp3.setText(p2.getRespuesta3());
                break;
            case 2:
                idPregunta.setText(getResources().getString(R.string.NumPregunta3));
                pregunta.setText(p3.getPregunta());
                rp1.setText(p3.getRespuesta1());
                rp2.setText(p3.getRespuesta2());
                rp3.setText(p3.getRespuesta3());
                break;
        }

        btnSend.setOnClickListener(view -> {
            if(avanzar) {

                if (Seleccion.equals(p1.getRespuestaCorrecta())) {

                    respuestasCorrectas++;

                    Intent irPantalla2 = new Intent(this, Pantalla2.class);
                    irPantalla2.putExtra("correctas",respuestasCorrectas);
                    irPantalla2.putExtra("incorrectas",respuestasIncorrectas);
                    startActivity(irPantalla2);

                }else{
                    respuestasIncorrectas++;

                    Intent irPantalla2 = new Intent(this, Pantalla2.class);
                    irPantalla2.putExtra("correctas",respuestasCorrectas);
                    irPantalla2.putExtra("incorrectas",respuestasIncorrectas);
                    startActivity(irPantalla2);
                }
                if (Seleccion.equals(p2.getRespuestaCorrecta())) {

                    respuestasCorrectas++;

                    Intent irPantalla2 = new Intent(this, Pantalla2.class);
                    irPantalla2.putExtra("correctas",respuestasCorrectas);
                    irPantalla2.putExtra("incorrectas",respuestasIncorrectas);
                    startActivity(irPantalla2);

                }else{
                    respuestasIncorrectas++;

                    Intent irPantalla2 = new Intent(this, Pantalla2.class);
                    irPantalla2.putExtra("correctas",respuestasCorrectas);
                    irPantalla2.putExtra("incorrectas",respuestasIncorrectas);
                    startActivity(irPantalla2);
                }

                if (Seleccion.equals(p3.getRespuestaCorrecta())) {

                    respuestasCorrectas++;

                    Intent irPantalla2 = new Intent(this, Pantalla2.class);
                    irPantalla2.putExtra("correctas",respuestasCorrectas);
                    irPantalla2.putExtra("incorrectas",respuestasIncorrectas);
                    startActivity(irPantalla2);

                }else{
                    respuestasIncorrectas++;

                    Intent irPantalla2 = new Intent(this, Pantalla2.class);
                    irPantalla2.putExtra("correctas",respuestasCorrectas);
                    irPantalla2.putExtra("incorrectas",respuestasIncorrectas);
                    startActivity(irPantalla2);
                }



            }else{
                Toast.makeText(this, getResources().getString(R.string.NoSeleccion), Toast.LENGTH_LONG).show();
            }


        });

    }

    public void clickOnAnswer(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButtonRespuesta1:
                Seleccion= getResources().getString(R.string.Respuesta1);
                avanzar=true;
                break;
            case R.id.radioButtonRespuesta2:
                Seleccion= getResources().getString(R.string.Respuesta2);
                avanzar=true;
                break;
            case R.id.radioButtonRespuesta3:
                Seleccion= getResources().getString(R.string.Respuesta3);
                avanzar=true;
                break;
        }

    }



}