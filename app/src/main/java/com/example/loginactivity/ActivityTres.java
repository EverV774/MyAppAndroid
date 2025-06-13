package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityTres extends AppCompatActivity {
    ListView colores;
    Button aceptar, r;
    EditText resultado;
    ArrayList<String> col;
    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tres);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        colores = findViewById(R.id.lista);
        aceptar = findViewById(R.id.button);
        resultado = findViewById(R.id.editTextText);
        r = findViewById(R.id.button15);

        col = new ArrayList<>();
        col.add("Rojo");
        col.add("Verde");
        col.add("Azul");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, col);
        colores.setAdapter(adapter);

        aceptar.setOnClickListener(v -> {
            String mensaje;
            int posicion = colores.getCheckedItemPosition();

            if(posicion == -1){
                mensaje = "No hay un color seleccionado.";
            } else{
                String colorSeleccionado = col.get(posicion);
                mensaje = "El color seleccionado es: " + colorSeleccionado;
            }
            resultado.setText(mensaje);
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}