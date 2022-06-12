package br.unir.pdm12_trocadetelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    private Button botaoPrimeiraTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        botaoPrimeiraTela = findViewById(R.id.botaoPrimeiraTela);

        botaoPrimeiraTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void abrirNavegador(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://unir.br/homepage"));
        startActivity(intent);
    }
}