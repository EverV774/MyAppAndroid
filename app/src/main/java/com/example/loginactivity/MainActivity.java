package com.example.loginactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Credenciales:
    // hevervelasco606@gmail.com
    // tap*2025

    // Declaracion de las variables.
    EditText correo, pass;
    Button login;
    ImageView Mostrar;
    TextView error, error2;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a los elementos del login.
        correo = findViewById(R.id.txtCorreo);
        pass = findViewById(R.id.txtPass);
        login = findViewById(R.id.btnLogin);
        Mostrar = findViewById(R.id.ivMostrar);
        error = findViewById(R.id.txtError);
        error2 = findViewById(R.id.txtError2);

        // Accion del boton login
        login.setOnClickListener(v -> {
            String us = correo.getText().toString().trim();
            String contrasenia = pass.getText().toString().trim();
            boolean co = true, pa = true;
            if(us.isEmpty()){
                error.setText("Campo vacio.");
                error.setVisibility(TextView.VISIBLE);
                co = false;
            } else if(!validar(us)){
                error.setText("Ingrese una contraseña valda.");
                error.setVisibility(TextView.VISIBLE);
                co = false;
            } else {
                error.setVisibility(TextView.GONE);
            }

            if(contrasenia.isEmpty()){
                error2.setText("Campo vacio.");
                error2.setVisibility(TextView.VISIBLE);
                pa = false;
            } else if(!contrasenia.trim().equals("tap*2025")){
                error2.setText("La contraseña es incorrecta.");
                error2.setVisibility(TextView.VISIBLE);
                pa = false;
            } else{
                error2.setVisibility(TextView.GONE);
            }

            if(co && pa){
                Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, bienvenidoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Accion del boton Mostrar
        Mostrar.setOnClickListener(v -> {
            if (pass.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                Mostrar.setImageResource(R.drawable.open);
            } else{
                pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                Mostrar.setImageResource(R.drawable.close);
            }
            
            pass.setSelection(pass.getText().length());
        });
    }

    public boolean validar(String correo){
        char[] co = correo.toCharArray();
        int i = correo.length()-1;
        String dom = "";
        for(i = i; i >= 0; i--){
            if(co[i] == '@'){
                for(int j = i; j < correo.length(); j++){
                    dom = dom + co[j];
                }
                break;
            }
        }
        boolean booleanCorreo = false;
        if(i != -1){
            if(dom.equals("@gmail.com") || dom.equals("@itoaxaca.edu.mx") || dom.equals("@hotmail.com") || dom.equals("@yahoo.com")){
                booleanCorreo = true;
            }
        }

        return booleanCorreo;
    }
}