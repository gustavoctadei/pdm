package br.unir.pdm17_bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button buttonCadastrar;
    private Button buttonPesquisar;

    private RadioGroup radioFiltro;

    private EditText editPesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastrar = findViewById(R.id.button_cadastrar);
        buttonPesquisar = findViewById(R.id.button_pesquisar);
        radioFiltro = findViewById(R.id.radio_filtro);
        editPesquisar = findViewById(R.id.edit_pesquisar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PesquisaActivity.class);

                int id = radioFiltro.getCheckedRadioButtonId();
                String busca = editPesquisar.getText().toString();

                intent.putExtra("tipo", id);
                intent.putExtra("busca", busca);
                startActivity(intent);
            }
        });

    }
}