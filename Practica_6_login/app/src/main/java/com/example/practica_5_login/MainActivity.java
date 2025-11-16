package com.example.practica_5_login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    private EditText tCorreo;
    private EditText tPass;
    private Button bContinuar;
    private Switch sRecordar;
    private Button bSiguientePantalla;
    private String correoGuardado;
    private String passGuardada;

    TextView txMensaje;


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

        tCorreo = findViewById(R.id.tCorreo);
        tPass = findViewById(R.id.tPass);
        bContinuar = findViewById(R.id.bContinuar);
        sRecordar = findViewById(R.id.sRecordar);
        txMensaje = findViewById(R.id.txMensaje);
        bSiguientePantalla = findViewById(R.id.bSiguientePantalla);


        bContinuar.setOnClickListener(v -> {

            String correo = tCorreo.getText().toString();
            String pass = tPass.getText().toString();

            boolean recordar = sRecordar.isChecked();

            correoGuardado = tCorreo.getText().toString();
            passGuardada = tPass.getText().toString();

            if (recordar) {


                if (correoGuardado.isEmpty() || passGuardada.isEmpty()) {
                    txMensaje.setText("El campo del correo o de la contraseña está vacio");
                    txMensaje.setTextColor(Color.RED);

                } else {

                    //correoGuardado = tCorreo.getText().toString();
                    //passGuardada = tPass.getText().toString();
                    if (correo.equals(correoGuardado) && pass.equals(passGuardada)) {
                        txMensaje.setText("Bienvenido");
                        txMensaje.setTextColor(Color.GREEN);
                        tCorreo.setText("");
                        tPass.setText("");
                    } else {
                        txMensaje.setText("Correo y/o contraseña incorrectos");
                        txMensaje.setTextColor(Color.RED);
                    }
                }

            } else if (correo.isEmpty() || pass.isEmpty()) {
                txMensaje.setText("El campo del correo o de la contraseña está vacio");
                txMensaje.setTextColor(Color.RED);

            } else if (correo.equals("correo@correo.com") && pass.equals("123")) {
                txMensaje.setText("Bienvenido");
                txMensaje.setTextColor(Color.GREEN);
            } else {
                txMensaje.setText("Correo y/o contraseña incorrectos");
                txMensaje.setTextColor(Color.RED);
            }


        });

        bSiguientePantalla.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivityInicio.class);
            intent.putExtra("correo", correoGuardado);

            startActivity(intent);



        });


    }
}