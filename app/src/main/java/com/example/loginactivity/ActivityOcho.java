package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityOcho extends AppCompatActivity {
    SeekBar slDeslizador;
    TextView lblValor;
    int valorMinimo = 100;
    Button r;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ocho);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        slDeslizador = findViewById(R.id.slDeslizador);
        lblValor = findViewById(R.id.lblValor);
        r = findViewById(R.id.button20);

        int valorInicial = 400 - valorMinimo;
        slDeslizador.setProgress(valorInicial);
        lblValor.setText("El valor es: " + (slDeslizador.getProgress() + valorMinimo));

        slDeslizador.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valorActual = progress + valorMinimo;
                lblValor.setText("El valor es: " + valorActual);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}