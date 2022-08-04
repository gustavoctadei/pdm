package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Aro20Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aro20);

        ImageButton imageButtonB13 = findViewById(R.id.imageButtonB13);
        imageButtonB13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(13);
            }
        });

        ImageButton imageButtonB14 = findViewById(R.id.imageButtonB14);
        imageButtonB14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(14);
            }
        });

        ImageButton imageButtonB15 = findViewById(R.id.imageButtonB15);
        imageButtonB15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(15);
            }
        });

        ImageButton imageButtonB16 = findViewById(R.id.imageButtonB16);
        imageButtonB16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(16);
            }
        });

        ImageButton imageButtonB17 = findViewById(R.id.imageButtonB16);
        imageButtonB17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(17);
            }
        });

        ImageButton imageButtonB18 = findViewById(R.id.imageButtonB17);
        imageButtonB18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualizarBicicleta(18);
            }
        });

        Button buttonInicioAro20 = findViewById(R.id.buttonInicioAro20);
        buttonInicioAro20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void visualizarBicicleta(Integer id) {
        Intent intent = new Intent(Aro20Activity.this, VisualizarBicicletaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}