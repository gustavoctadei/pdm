package br.unir.pdm17_bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    private Button buttonVoltar;
    private TableLayout tabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        buttonVoltar = findViewById(R.id.button_voltar_pesquisar);
        tabela = findViewById(R.id.table_pesquisa);

        Intent intent = getIntent();
        int tipo = intent.getIntExtra("tipo", 0);
        String busca = intent.getStringExtra("busca");

        List<ContentValues> lista = new ArrayList<>();
        BancoControlador db = new BancoControlador(getApplicationContext());

        if (tipo == R.id.radio_titulo) {
            lista = db.pesquisarPorTitulo(busca);

        } else if (tipo == R.id.radio_ano) {
            lista = db.pesquisarPorAno(Integer.parseInt(busca));

        } else if (tipo == R.id.radio_todos) {
            lista = db.pesquisarPorTodos();
        }

        if (lista != null && !lista.isEmpty()) {
            for (ContentValues cv : lista) {
                TableRow tr = new TableRow(getApplicationContext());

                TextView colunaId = new TextView(getApplicationContext());
                colunaId.setText( String.valueOf( cv.getAsInteger("id" ) ) );

                TextView colunaTitulo = new TextView(getApplicationContext());
                colunaTitulo.setText( cv.getAsString("titulo") );

                TextView colunaAutor = new TextView(getApplicationContext());
                colunaAutor.setText( cv.getAsString("autor") );

                TextView colunaAno = new TextView(getApplicationContext());
                colunaAno.setText( String.valueOf( cv.getAsInteger("ano" ) ) );

                tr.addView(colunaId);
                tr.addView(colunaTitulo);
                tr.addView(colunaAutor);
                tr.addView(colunaAno);

                tr.setPadding(24, 8, 8, 8);

                tabela.addView(tr);
            }
        }

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}