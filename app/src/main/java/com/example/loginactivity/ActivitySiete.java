package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitySiete extends AppCompatActivity {
    EditText txtPrecioBase, lblTotal;
    ToggleButton tbtnInstalacion, tbtnFormacion, tbtnAlimentacionBD;
    Button btnCalcular, r;

    @SuppressLint({"WrongViewCast", "CutPasteId", "SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_siete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtPrecioBase = findViewById(R.id.editTextText5);
        tbtnInstalacion = findViewById(R.id.button9);
        tbtnFormacion = findViewById(R.id.button10);
        tbtnAlimentacionBD = findViewById(R.id.button11);
        r = findViewById(R.id.button19);
        lblTotal = findViewById(R.id.editTextText6);
        btnCalcular = findViewById(R.id.button12);

        tbtnInstalacion.setChecked(true);

        btnCalcular.setOnClickListener(v -> {
            try{
                double precio_base = Double.parseDouble(txtPrecioBase.getText().toString());
                double precio_instal = 40;
                double precio_for = 200;
                double precio_ali = 200;

                double precio_total = precio_base;

                if (tbtnInstalacion.isChecked()) {
                    precio_total += precio_instal;
                }
                if (tbtnFormacion.isChecked()) {
                    precio_total += precio_for;
                }
                if (tbtnAlimentacionBD.isChecked()) {
                    precio_total += precio_ali;
                }

                lblTotal.setText("Total: " + precio_total + " $");
            } catch (Exception e) {
                lblTotal.setText("Error: ingresa precio válido");
            }
        });

        r.setOnClickListener(v -> {
            finish();
        });
    }
}