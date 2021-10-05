package com.example.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act_tipo_usuario extends AppCompatActivity {

    Button estudiante, tutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_tipo_usuario);

        estudiante = findViewById(R.id.btnEst);
        tutor = findViewById(R.id.btnTutor);

        estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(act_tipo_usuario.this, act_datos_principales.class);
               startActivity(intent);
            }
        });

        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_tipo_usuario.this, act_datos_principales.class);
                startActivity(intent);
            }
        });
    }
}