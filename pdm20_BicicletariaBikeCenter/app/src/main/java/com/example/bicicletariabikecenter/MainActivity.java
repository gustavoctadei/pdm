package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bicicletariabikecenter.dao.BicicletaDao;
import com.example.bicicletariabikecenter.model.Bicicleta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BicicletaDao bicicletaDao = new BicicletaDao(getApplicationContext());

        List<Bicicleta> listaBicicleta = new ArrayList<>();
        listaBicicleta = bicicletaDao.listar();

        if (listaBicicleta.isEmpty()) {
            bicicletaDao.inserirBicicletas();
        }

        TextView textAro12 = findViewById(R.id.textAro12);
        textAro12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Aro12Activity.class);
                startActivity(intent);
            }
        });

        TextView textAro16 = findViewById(R.id.textAro16);
        textAro16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Aro16Activity.class);
                startActivity(intent);
            }
        });

        TextView textAro20 = findViewById(R.id.textAro20);
        textAro20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Aro20Activity.class);
                startActivity(intent);
            }
        });

        TextView textAro24 = findViewById(R.id.textAro24);
        textAro24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Aro24Activity.class);
                startActivity(intent);
            }
        });

        TextView textAro26 = findViewById(R.id.textAro26);
        textAro26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Aro26Activity.class);
                startActivity(intent);
            }
        });

        TextView textAro29 = findViewById(R.id.textAro29);
        textAro29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Aro29Activity.class);
                startActivity(intent);
            }
        });

        Button buttonFavoritos = findViewById(R.id.buttonFavoritos);
        buttonFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

    }
}