package br.unir.pdm14_riscocardiovascular;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();

        TextView textNomeResultado = findViewById(R.id.textNomeResultado);
        textNomeResultado.setText( "Nome: " + intent.getStringExtra("nome") );

        TextView textIdadeResultado = findViewById(R.id.textIdadeResultado);
        textIdadeResultado.setText( "Idade: " + intent.getStringExtra("idade") );

        TextView textSexoResultado = findViewById(R.id.textSexoResultado);
        textSexoResultado.setText( "Sexo: " + intent.getStringExtra("sexo") );

        TextView textRcqResultado = findViewById(R.id.textRcqResultado);
        textRcqResultado.setText( "RCQ: " + intent.getStringExtra("rcq") );

        TextView textClassificacaoResultado = findViewById(R.id.textClassificacaoResultado);
        textClassificacaoResultado.setText( "Classificação: " + intent.getStringExtra("classificacao") );

        Button buttonTelaInicialResultado = findViewById(R.id.buttonTelaInicialResultado);
        buttonTelaInicialResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resultado.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}