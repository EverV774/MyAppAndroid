package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityUno extends AppCompatActivity {
    CheckBox perro, gato, raton;
    Button aceptar, r;
    EditText resultado;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_uno);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        perro = findViewById(R.id.boxPerro);
        gato = findViewById(R.id.boxGato);
        raton = findViewById(R.id.boxRaton);
        aceptar = findViewById(R.id.btnAceptar);
        resultado = findViewById(R.id.txtResultado);
        r = findViewById(R.id.button13);

        aceptar.setOnClickListener(v -> {
            String mensaje = "Animales elegidos: ";
            if(perro.isChecked()){
                mensaje += "Perro ";
            }
            if(gato.isChecked()){
                mensaje += "Gato ";
            }
            if(raton.isChecked()){
                mensaje += "Raton ";
            }

            resultado.setText(mensaje);
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}