package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Aro29Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aro29);

        ImageButton imageButtonB29 = findViewById(R.id.imageButtonB29);
        imageButtonB29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(29);
            }
        });

        ImageButton imageButtonB30 = findViewById(R.id.imageButtonB30);
        imageButtonB30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(30);
            }
        });

        ImageButton imageButtonB31 = findViewById(R.id.imageButtonB31);
        imageButtonB31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(31);
            }
        });

        ImageButton imageButtonB32 = findViewById(R.id.imageButtonB32);
        imageButtonB32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(32);
            }
        });

        Button buttonInicioAro29 = findViewById(R.id.buttonInicioAro29);
        buttonInicioAro29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void visualizarBicicleta(Integer id) {
        Intent intent = new Intent(Aro29Activity.this, VisualizarBicicletaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}