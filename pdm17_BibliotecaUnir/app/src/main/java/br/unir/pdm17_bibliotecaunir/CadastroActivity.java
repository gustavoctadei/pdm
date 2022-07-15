package br.unir.pdm17_bibliotecaunir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.ConnectException;

public class CadastroActivity extends AppCompatActivity {

    private Button buttonSalvar, buttonVoltar;
    private EditText editTextTitulo, editTextAutor, editTextAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        buttonSalvar = findViewById(R.id.button_salvar);
        buttonVoltar = findViewById(R.id.button_voltar);
        editTextTitulo = findViewById(R.id.edit_titulo);
        editTextAutor = findViewById(R.id.edit_autor);
        editTextAno = findViewById(R.id.edit_ano);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                String titulo = editTextTitulo.getText().toString();
                String autor = editTextAutor.getText().toString();
                String ano = editTextAno.getText().toString();

                cv.put("titulo", titulo);
                cv.put("autor", autor);
                cv.put("ano", ano);

                BancoControlador bd = new BancoControlador(getApplicationContext());
                String msg = "";
                long res = bd.inserir(cv);

                if (res > 0) {
                    msg = "Operação realizada com sucesso.";
                    editTextTitulo.setText("");
                    editTextAutor.setText("");
                    editTextAno.setText("");

                } else {
                    msg = "Ocorreu um erro durante a operação";
                }

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}