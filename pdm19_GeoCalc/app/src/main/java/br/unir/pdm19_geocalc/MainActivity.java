package br.unir.pdm19_geocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        Button buttonIniciar = findViewById(R.id.button_iniciar);
        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculaActivity();
            }
        });

    }

    private void calculaActivity() {
        Intent intent = new Intent(MainActivity.this, CalculaActivity.class);
        startActivity(intent);
    }
}