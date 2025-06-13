package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityNueve extends AppCompatActivity {
    NumberPicker spiValor;
    TextView lblValor2;
    Button r;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nueve);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spiValor = findViewById(R.id.spiValor);
        lblValor2 = findViewById(R.id.lblValor2);
        r = findViewById(R.id.button21);
        spiValor.setMinValue(0);
        spiValor.setMaxValue(10);
        spiValor.setValue(4);
        spiValor.setWrapSelectorWheel(false);

        String[] valores = new String[] {"0", "2", "4", "6", "8", "10"};
        spiValor.setDisplayedValues(valores);
        spiValor.setMinValue(0);
        spiValor.setMaxValue(valores.length - 1);

        spiValor.setOnValueChangedListener((picker, oldVal, newVal) -> {
            lblValor2.setText("El valor es: " + valores[newVal]);
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}