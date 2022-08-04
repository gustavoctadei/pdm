package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Aro24Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aro24);

        ImageButton imageButtonB19 = findViewById(R.id.imageButtonB19);
        imageButtonB19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(19);
            }
        });

        ImageButton imageButtonB20 = findViewById(R.id.imageButtonB20);
        imageButtonB20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(20);
            }
        });

        ImageButton imageButtonB21 = findViewById(R.id.imageButtonB21);
        imageButtonB21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(21);
            }
        });

        ImageButton imageButtonB22 = findViewById(R.id.imageButtonB22);
        imageButtonB22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(22);
            }
        });

        Button buttonInicioAro24 = findViewById(R.id.buttonInicioAro24);
        buttonInicioAro24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void visualizarBicicleta(Integer id) {
        Intent intent = new Intent(Aro24Activity.this, VisualizarBicicletaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}