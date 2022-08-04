package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Aro16Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aro16);

        ImageButton imageButtonB7 = findViewById(R.id.imageButtonB7);
        imageButtonB7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(7);
            }
        });

        ImageButton imageButtonB2 = findViewById(R.id.imageButtonB8);
        imageButtonB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(8);
            }
        });

        ImageButton imageButtonB3 = findViewById(R.id.imageButtonB9);
        imageButtonB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(9);
            }
        });

        ImageButton imageButtonB4 = findViewById(R.id.imageButtonB10);
        imageButtonB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(10);
            }
        });

        ImageButton imageButtonB5 = findViewById(R.id.imageButtonB11);
        imageButtonB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(11);
            }
        });

        ImageButton imageButtonB6 = findViewById(R.id.imageButtonB12);
        imageButtonB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(12);
            }
        });

        Button buttonInicioAro16 = findViewById(R.id.buttonInicioAro16);
        buttonInicioAro16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void visualizarBicicleta(Integer id) {
        Intent intent = new Intent(Aro16Activity.this, VisualizarBicicletaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}