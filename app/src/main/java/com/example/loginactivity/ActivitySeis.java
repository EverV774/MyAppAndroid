package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivitySeis extends AppCompatActivity {
    Spinner cboNumeros;
    Button btnPares, btnImpares, btnVaciar, r;
    TextView lblResultado;
    ArrayAdapter<String> adapter;
    ArrayList<String> modelo;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seis);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cboNumeros = findViewById(R.id.spinner2);
        btnPares = findViewById(R.id.button6);
        btnImpares = findViewById(R.id.button7);
        btnVaciar = findViewById(R.id.button8);
        lblResultado = findViewById(R.id.editTextText4);
        r = findViewById(R.id.button18);

        modelo = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cboNumeros.setAdapter(adapter);

        btnPares.setOnClickListener(v -> {
            modelo.clear();
            for (int i = 0; i < 10; i += 2) {
                modelo.add("No " + i);
            }
            adapter.notifyDataSetChanged();
        });

        btnImpares.setOnClickListener(v -> {
            modelo.clear();
            for (int i = 1; i < 10; i += 2) {
                modelo.add("No " + i);
            }
            adapter.notifyDataSetChanged();
        });

        btnVaciar.setOnClickListener(v -> {
            modelo.clear();
            adapter.notifyDataSetChanged();
            lblResultado.setText("Resultado");
        });

        cboNumeros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccionado = modelo.get(position);
                lblResultado.setText(seleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                lblResultado.setText("");
            }
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}