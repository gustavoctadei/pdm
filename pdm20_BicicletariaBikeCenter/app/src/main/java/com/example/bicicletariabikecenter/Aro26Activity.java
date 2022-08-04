package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Aro26Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aro26);

        ImageButton imageButtonB23 = findViewById(R.id.imageButtonB23);
        imageButtonB23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(23);
            }
        });

        ImageButton imageButtonB24 = findViewById(R.id.imageButtonB24);
        imageButtonB24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(24);
            }
        });

        ImageButton imageButtonB25 = findViewById(R.id.imageButtonB25);
        imageButtonB25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(25);
            }
        });

        ImageButton imageButtonB26 = findViewById(R.id.imageButtonB26);
        imageButtonB26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(26);
            }
        });

        ImageButton imageButtonB27 = findViewById(R.id.imageButtonB27);
        imageButtonB27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(27);
            }
        });

        ImageButton imageButtonB28 = findViewById(R.id.imageButtonB28);
        imageButtonB28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(28);
            }
        });

        Button buttonInicioAro26 = findViewById(R.id.buttonInicioAro26);
        buttonInicioAro26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void visualizarBicicleta(Integer id) {
        Intent intent = new Intent(Aro26Activity.this, VisualizarBicicletaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}