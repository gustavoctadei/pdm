package br.unir.pdm_18_listatarefasapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import br.unir.pdm_18_listatarefasapp.R;
import br.unir.pdm_18_listatarefasapp.helper.TarefaDao;
import br.unir.pdm_18_listatarefasapp.model.Tarefa;

public class TarefaActivity extends AppCompatActivity {

    private TextInputEditText editTextTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        editTextTarefa = findViewById(R.id.edit_text_tarefa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemSalvar:
                TarefaDao tarefaDao = new TarefaDao(getApplicationContext());

                if (!editTextTarefa.getText().toString().isEmpty()) {
                    Tarefa tarefa  = new Tarefa();
                    tarefa.setNomeTarefa( editTextTarefa.getText().toString() );

                    if (tarefaDao.salvar(tarefa)) {
                        Toast.makeText(getApplicationContext(), "Tarefa salva!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa!!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Preencha o nome da tarefa!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}