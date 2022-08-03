package com.example.bicicletariabikecenter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bicicletariabikecenter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textAro12 = findViewById(R.id.textAro12);
        textAro12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, aro12.class);
                //startActivity(intent);
            }
        });

        TextView textAro16 = findViewById(R.id.textAro16);
        textAro16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, aro12.class);
                //startActivity(intent);
            }
        });

        TextView textAro20 = findViewById(R.id.textAro20);
        textAro20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, aro20.class);
                //startActivity(intent);
            }
        });

        TextView textAro24 = findViewById(R.id.textAro24);
        textAro24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, aro24.class);
                //startActivity(intent);
            }
        });

        TextView textAro26 = findViewById(R.id.textAro26);
        textAro26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, aro26.class);
                //startActivity(intent);
            }
        });

        TextView textAro29 = findViewById(R.id.textAro29);
        textAro16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, aro29.class);
                //startActivity(intent);
            }
        });

    }
}