package br.unir.pdm05_app_sorveteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pedido extends AppCompatActivity {

    private TextView textoResultado;
    private Button botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        textoResultado = findViewById(R.id.txt_resultado);
        botaoVoltar = findViewById(R.id.btn_voltar);

        Intent intent = getIntent();
        String sabor = intent.getStringExtra("sabor");
        int quantidade = intent.getIntExtra("quantidade", 0);
        String tipo = intent.getStringExtra("tipo");

        double valor = 0;
        switch (tipo) {
            case "Cone":
                valor = quantidade * 2.50;
                break;

            case "Cone Duplo":
                valor = quantidade * 4.50;
                break;

            case "Picolé":
                valor = quantidade * 1.50;
                break;

            case "Sundae":
                valor = quantidade * 8.50;
                break;
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("Tipo: ").append(tipo).append("\n");
        resultado.append("Sabor: ").append(sabor).append("\n");
        resultado.append("Quantidade: ").append(quantidade).append("\n");
        resultado.append("\nValor total: ").append(valor).append("\n");

        textoResultado.setText(resultado);

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}