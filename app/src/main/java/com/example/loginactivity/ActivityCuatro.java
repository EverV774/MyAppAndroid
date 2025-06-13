package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityCuatro extends AppCompatActivity {
    Spinner lista;
    Button aceptar, r;
    EditText resultado;
    ArrayList<String> listaColores;
    ArrayAdapter<String> adapter;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuatro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lista = findViewById(R.id.spinner);
        aceptar = findViewById(R.id.button2);
        resultado = findViewById(R.id.editTextText2);
        listaColores = new ArrayList<>();
        listaColores.add("Rojo");
        listaColores.add("Verde");
        listaColores.add("Azul");
        r = findViewById(R.id.button16);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaColores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista.setAdapter(adapter);

        aceptar.setOnClickListener(v -> {
            String color = lista.getSelectedItem().toString();
            resultado.setText("Color seleccionado: " + color);
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}