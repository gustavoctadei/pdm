package br.unir.pdm05_app_sorveteria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerTipo;
    private RadioGroup radioGroup;
    private EditText editQuantidade;
    private Button botaoFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerTipo = findViewById(R.id.spn_tipo);
        radioGroup = findViewById(R.id.radioGroup);
        editQuantidade = findViewById(R.id.edt_quantidade);
        botaoFinalizar = findViewById(R.id.btn_finalizar);

        botaoFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
                janela.setTitle(R.string.app_name);
                janela.setMessage("Tem certeza que deseja finalizar o pedido?");

                janela.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        abrirAtividade();
                    }
                });

                janela.setNegativeButton("Não", null);

                janela.show();
            }
        });

        carregarTipos();
    }

    public void carregarTipos() {
        String tipos[] = {"Cone", "Cone Duplo", "Picolé", "Sundae"};

        ArrayAdapter<String> adp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipos);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adp);
    }

    public void abrirAtividade() {
        String tipo = spinnerTipo.getSelectedItem().toString();

        int idSabor = radioGroup.getCheckedRadioButtonId();
        RadioButton radioSabor = findViewById(idSabor);
        String sabor = radioSabor.getText().toString();

        int quantidade = 0;

        if (!editQuantidade.getText().toString().isEmpty()) {
            quantidade = Integer.parseInt(editQuantidade.getText().toString());
        }

        Intent intent = new Intent(MainActivity.this, Pedido.class);
        intent.putExtra("tipo", tipo);
        intent.putExtra("sabor", sabor);
        intent.putExtra("quantidade", quantidade);
        startActivity(intent);
    }
}