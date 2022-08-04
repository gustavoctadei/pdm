package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Aro12Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aro12);

        ImageButton imageButtonB1 = findViewById(R.id.imageButtonB1);
        imageButtonB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(1);
            }
        });

        ImageButton imageButtonB2 = findViewById(R.id.imageButtonB2);
        imageButtonB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(2);
            }
        });

        ImageButton imageButtonB3 = findViewById(R.id.imageButtonB3);
        imageButtonB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(3);
            }
        });

        ImageButton imageButtonB4 = findViewById(R.id.imageButtonB4);
        imageButtonB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(4);
            }
        });

        ImageButton imageButtonB5 = findViewById(R.id.imageButtonB5);
        imageButtonB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(5);
            }
        });

        ImageButton imageButtonB6 = findViewById(R.id.imageButtonB6);
        imageButtonB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(6);
            }
        });

        Button buttonInicioAro12 = findViewById(R.id.buttonInicioAro12);
        buttonInicioAro12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void visualizarBicicleta(Integer id) {
        Intent intent = new Intent(Aro12Activity.this, VisualizarBicicletaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}