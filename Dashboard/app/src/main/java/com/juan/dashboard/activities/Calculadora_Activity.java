package com.juan.dashboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.juan.dashboard.R;

public class Calculadora_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        setTitle("Calculadora");
        EditText numuno = findViewById(R.id.NUM1);
        EditText numdos = findViewById(R.id.NUM2);
        TextView resultadoText = findViewById(R.id.textResultado);
        Button suma = findViewById(R.id.btnSuma);
        Button resta = findViewById(R.id.btnResta);
        Button multi = findViewById(R.id.btnMulti);
        Button div = findViewById(R.id.btnDiv);
        String msgResultado=resultadoText.getText().toString();

        suma.setOnClickListener( view -> {
            //3- recogemos el texto de los edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();

            if (!(num1.isEmpty()||num2.isEmpty())) {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = numero1 + numero2;
                resultadoText.setText(msgResultado+" "+resultado);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

            }
        });

        resta.setOnClickListener( view -> {
            //3- recogemos el texto de los edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();

            if (!(num1.isEmpty()||num2.isEmpty())) {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = numero1 - numero2;
                resultadoText.setText(msgResultado+" "+resultado);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

            }
        });

        multi.setOnClickListener( view -> {
            //3- recogemos el texto de los edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();

            if (!(num1.isEmpty()||num2.isEmpty())) {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = numero1 * numero2;
                resultadoText.setText(msgResultado+" "+resultado);
            } else{
                Log.d("MainActivity","Has introducido un campo vacio");
                Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

            }
        });

        div.setOnClickListener( view -> {
            //3- recogemos el texto de los edit text
            String num1 = numuno.getText().toString();
            String num2 = numdos.getText().toString();
            try {
                if (!(num1.isEmpty()||num2.isEmpty())) {
                    int numero1 = Integer.parseInt(num1);
                    int numero2 = Integer.parseInt(num2);
                    int resultado = numero1 / numero2;
                    resultadoText.setText(msgResultado+" "+resultado);
                } else{
                    Log.d("MainActivity","Has introducido un campo vacio");
                    Toast.makeText(this, getString(R.string.msg_toast),Toast.LENGTH_LONG).show();

                }
            }

            /* En caso de que surja algún error
             * de tipo aritmético,Por ejemplo,
             * que no se puede dividir entre cero*/
            catch (ArithmeticException e){
                Toast.makeText(this, getString(R.string.msg_toast2),Toast.LENGTH_LONG).show();
            }

        });
    }
}