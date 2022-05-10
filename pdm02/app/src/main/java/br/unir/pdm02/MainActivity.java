package br.unir.pdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textNumeroSorteado;

    private Button botaoJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNumeroSorteado = findViewById(R.id.numeroSorteado);
        botaoJogar = findViewById(R.id.botaoJogar);

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                Integer numeroSorteado = random.nextInt(11);

                textNumeroSorteado.setText(numeroSorteado.toString());
            }
        });
    }

}