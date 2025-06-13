package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bienvenidoActivity extends AppCompatActivity {
    ImageButton uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bienvenido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        uno = findViewById(R.id.btnUno);
        dos = findViewById(R.id.btnDos);
        tres = findViewById(R.id.btnTres);
        cuatro = findViewById(R.id.btnCuatro);
        cinco = findViewById(R.id.btnCinco);
        seis = findViewById(R.id.btnSeis);
        siete = findViewById(R.id.btnSiete);
        ocho = findViewById(R.id.btnOcho);
        nueve = findViewById(R.id.btnNueve);
        diez = findViewById(R.id.btnDiez);

        uno.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 1!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityUno.class);
            startActivity(intent);
        });

        dos.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 2!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityDos.class);
            startActivity(intent);
        });

        tres.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 3!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityTres.class);
            startActivity(intent);
        });

        cuatro.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 4!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityCuatro.class);
            startActivity(intent);
        });

        cinco.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 5!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityCinco.class);
            startActivity(intent);
        });

        seis.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 6!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivitySeis.class);
            startActivity(intent);
        });

        siete.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 7!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivitySiete.class);
            startActivity(intent);
        });

        ocho.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 8!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityOcho.class);
            startActivity(intent);
        });

        nueve.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 9!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityNueve.class);
            startActivity(intent);
        });

        diez.setOnClickListener(v -> {
            Toast.makeText(this, "¡Actividad 10!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(bienvenidoActivity.this, ActivityDiez.class);
            startActivity(intent);
        });
    }
}