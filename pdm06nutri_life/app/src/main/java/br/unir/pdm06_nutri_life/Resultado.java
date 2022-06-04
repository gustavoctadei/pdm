package br.unir.pdm06_nutri_life;

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

        TextView textResultadoNome = findViewById(R.id.text_resultado_nome);
        textResultadoNome.setText(intent.getStringExtra("nome"));

        TextView textResultadoImc = findViewById(R.id.text_resultado_imc);
        textResultadoImc.setText(intent.getStringExtra("imc"));

        TextView textResultadoClassificacao = findViewById(R.id.text_resultado_classificacao);
        textResultadoClassificacao.setText(intent.getStringExtra("classificacao"));

        TextView textResultadoRiscos = findViewById(R.id.text_resultado_riscos);
        textResultadoRiscos.setText(intent.getStringExtra("riscos"));

        Button botaoVoltar = findViewById(R.id.botao_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}