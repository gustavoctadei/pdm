package br.unir.pdm09_appnotas;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.unir.pdm09_appnotas.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnotacaoPreferencias preferencia;

    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencia = new AnotacaoPreferencias(getApplicationContext());

        String anotacao = preferencia.recuperarAnotacao();

        if (!anotacao.isEmpty()) {
            editAnotacao.setText(anotacao);
        }

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String anotacao = editAnotacao.getText().toString();
                String mensagem;

                if (!anotacao.isEmpty()) {
                    preferencia.salvar(anotacao);
                    mensagem = "Anotação salva com sucesso.";

                } else {
                    mensagem = "Preencha a anotação.";
                }

                Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG).show();
            }
        });
    }

}