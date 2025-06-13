package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityDos extends AppCompatActivity {
    RadioButton rojo, azul, verde;
    Button aceptar, r;
    EditText resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rojo = findViewById(R.id.raRojo);
        azul = findViewById(R.id.raAzul);
        verde = findViewById(R.id.raVerde);
        aceptar = findViewById(R.id.buttonA);
        resultado = findViewById(R.id.resultado);
        r = findViewById(R.id.button14);

        aceptar.setOnClickListener(v -> {
            String mensaje = "Color elegido: ";
            if(rojo.isChecked()){
                mensaje += "Rojo";
            }
            if(azul.isChecked()){
                mensaje += "Azul";
            }
            if(verde.isChecked()){
                mensaje += "Verde";
            }
            resultado.setText(mensaje);
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}