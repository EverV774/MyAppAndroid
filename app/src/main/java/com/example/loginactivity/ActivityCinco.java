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

public class ActivityCinco extends AppCompatActivity {
    ListView lstNombres;
    Button btnCurso1, btnCurso2, btnVaciar, r;
    EditText resultado;
    ArrayList<String    > modelo;
    ArrayAdapter<String> adapter;


    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cinco);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lstNombres = findViewById(R.id.listView);
        btnCurso1 = findViewById(R.id.button3);
        btnCurso2 = findViewById(R.id.button4);
        btnVaciar = findViewById(R.id.button5);
        resultado = findViewById(R.id.editTextText3);
        r = findViewById(R.id.button17);

        modelo = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, modelo);
        lstNombres.setAdapter(adapter);
        lstNombres.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnCurso1.setOnClickListener(v -> {
            resultado.setText("");
            modelo.clear();
            modelo.add("Juan");
            modelo.add("María");
            modelo.add("Luis");
            adapter.notifyDataSetChanged();
        });

        btnCurso2.setOnClickListener(v -> {
            resultado.setText("");
            modelo.clear();
            modelo.add("Ana");
            modelo.add("Marta");
            modelo.add("Jose");
            adapter.notifyDataSetChanged();
        });

        btnVaciar.setOnClickListener(v -> {
            modelo.clear();
            adapter.notifyDataSetChanged();
            resultado.setText("");
        });

        lstNombres.setOnItemClickListener((parent, view, position, id) -> {
            String seleccionado = modelo.get(position);
            resultado.setText(seleccionado);
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}