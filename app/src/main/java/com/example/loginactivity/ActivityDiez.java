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

public class ActivityDiez extends AppCompatActivity {
    SeekBar desValor;
    TextView lblValor;
    Button r;
    final int minimo = 50;
    final int maximo = 150;
    final int visibleAmount = 5;
    final int valorInicial = 70;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diez);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        desValor = findViewById(R.id.desValor);
        lblValor = findViewById(R.id.lblValor3);
        r = findViewById(R.id.button22);
        int rango = maximo - minimo - visibleAmount;
        desValor.setMax(rango);
        desValor.setProgress(valorInicial - minimo);

        lblValor.setText("El valor es: " + valorInicial);

        desValor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valorReal = minimo + progress;
                lblValor.setText("El valor es: " + valorReal);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}