package com.edincodes.sumardosnumeros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperar Widgets de XML, no es obligatorio que tengan el mismo nombre
        // pero es una buena práctica (y eso que dije que no veríamos buenas prácticas)
        final EditText editText = findViewById(R.id.editText),
                editText2 = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button);
        // Ahora agregamos un listener al botón para saber cuando le den click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recuperamos los valores como String
                String numero1String = editText.getText().toString(),
                        numero2String = editText2.getText().toString();
                // Simple validación, si quieres ver una más bonita visita:
                // https://parzibyte.me/blog/2019/02/25/validar-edittext-android-seterror-tooltip/

                // Si las cadenas están vacías...
                if (numero1String.equals("") || numero2String.equals("")) {
                    // Detener ejecución del método
                    return;
                }

                // Si el método no se detuvo...
                // Convertir esas String a números Int, porque no podemos sumar cadenas
                int numero1 = Integer.parseInt(numero1String),
                        numero2 = Integer.parseInt(numero2String);
                // Hacer la suma
                int suma = numero1 + numero2;
                // Crear un Intent para cambiar
                // Nota: al momento Actividad2 no está creada, ahorita la creamos
                Intent intent = new Intent(MainActivity.this, Actividad2.class);
                // Agregarle los datos que le pasamos
                // Nota: "suma" es la clave con la que lo vamos a obtener "del otro lado"
                intent.putExtra("suma", suma);

                // Y ahora que ya tiene datos, cambiamos de actividad
                // Nos vemos en Actividad2.java
                startActivity(intent);
            }
        });
    }
}