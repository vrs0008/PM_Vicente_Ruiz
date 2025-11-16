package com.example.practica_5_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityInicio extends AppCompatActivity {

    private TextView txBienvenida;
    private Button bDesconectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txBienvenida = findViewById(R.id.txBienvenida);
        bDesconectar = findViewById(R.id.bDesconectar);

        String correo = getIntent().getStringExtra("correo");
        txBienvenida.setText("Hola, tu correo es: " + correo);

        bDesconectar.setOnClickListener(v -> {
            finish();

        });


    }
}