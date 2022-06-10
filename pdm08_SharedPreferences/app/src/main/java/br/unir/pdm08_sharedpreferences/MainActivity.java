package br.unir.pdm08_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoSalvar;
    private EditText inputNome;
    private TextView textNome;

    private static final String ARQUIVO_PREFERENCIA = "arquivo_preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoSalvar = findViewById(R.id.botaoSalvar);
        textNome = findViewById(R.id.textNome);
        inputNome = findViewById(R.id.inputNome);

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, MODE_PRIVATE);

        if (preferences.contains("nome")) {
            String nome = preferences.getString("nome", "");
            textNome.setText("Olá de novo, " + nome);

        } else {
            textNome.setText("Usuário não definido");
        }

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                //Pegar todas as chaves, guardar em um array
                //preferences.getAll().keySet();

                if (!inputNome.getText().toString().isEmpty()) {
                    String nome = inputNome.getText().toString();

                    editor.putString("nome", nome);
                    editor.commit();

                    textNome.setText("Olá, " + nome);

                } else {
                    Toast.makeText(getApplicationContext(), "Preencha o campo!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}