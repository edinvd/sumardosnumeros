package com.edincodes.sumardosnumeros;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        // Obtener los datos que nos pasaron. El 0 es por si no se nos pasara
        // nada, ya que se necesita un valor por defecto (defaultValue)
        Intent intent = getIntent();
        int sumaQueNosPasaron = intent.getIntExtra("suma", 0);

        // Obtener Widget de vista
        TextView textView = findViewById(R.id.textView);

        // Armar un mensaje
        String mensaje = "La suma es: " + sumaQueNosPasaron;
        // Y ponerle la suma
        textView.setText(mensaje);
    }
}
