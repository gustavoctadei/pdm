package br.unir.pdm14_riscocardiovascular;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalcularMain;
    private Button buttonLimparMain;
    private FloatingActionButton  buttonHistoricoMain;

    private EditText inputNomeMain;
    private EditText inputIdadeMain;
    private EditText inputCinturaMain;
    private EditText inputQuadrilMain;
    private RadioButton radioMasculino;
    private RadioButton radioFeminino;

    private SharedPreferencesUtil sharedPreferencesUtil;
    private List<Rcq> historicoRcq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());

        buttonCalcularMain = findViewById(R.id.buttonCalcularMain);
        buttonHistoricoMain = findViewById(R.id.buttonHistoricoMain);
        buttonLimparMain = findViewById(R.id.buttonLimparMain);

        inputNomeMain = findViewById(R.id.inputNomeMain);
        inputIdadeMain = findViewById(R.id.inputIdadeMain);
        inputCinturaMain = findViewById(R.id.inputCinturaMain);
        inputQuadrilMain = findViewById(R.id.inputQuadrilMain);
        radioMasculino = findViewById(R.id.radioMasculino);
        radioFeminino = findViewById(R.id.radioFeminino);

        limpaCampos();

        buttonCalcularMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionButtonCalcularMain();
            }
        });

        buttonHistoricoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionButtonHistoricoMain();
            }
        });

        buttonLimparMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
                Toast.makeText(getApplicationContext(), "Os campos foram limpados!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void actionButtonCalcularMain() {
        if (inputNomeMain.getText().toString().isEmpty() || inputIdadeMain.getText().toString().isEmpty()
                || inputCinturaMain.getText().toString().isEmpty() || inputQuadrilMain.getText().toString().isEmpty()
                || (!radioMasculino.isChecked() && !radioFeminino.isChecked())) {
            Toast.makeText(getApplicationContext(), "É necessário preencher todos os campos!", Toast.LENGTH_LONG).show();
            return;
        }

        if (Integer.valueOf( inputIdadeMain.getText().toString() ) < 20 || Integer.valueOf( inputIdadeMain.getText().toString() ) > 69) {
            Toast.makeText(getApplicationContext(), "Idade fora da escala!", Toast.LENGTH_LONG).show();
            return;
        }

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Confirmação");
        alertDialog.setMessage("Os dados estão corretos?");

        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nome = inputNomeMain.getText().toString();
                Integer idade = Integer.valueOf( inputIdadeMain.getText().toString() );
                Float cintura = Float.valueOf( inputCinturaMain.getText().toString() );
                Float quadril = Float.valueOf( inputQuadrilMain.getText().toString() );
                Float valorRcq = cintura / quadril;

                Rcq rcq = new Rcq();
                rcq.setNome(nome);
                rcq.setIdade(idade);
                rcq.setRcq(valorRcq);

                if (radioMasculino.isChecked()) rcq.setSexo("Masculino");
                else rcq.setSexo("Feminino");

                if (rcq.getSexo().equals("Masculino")) {
                    //Masculino
                    if (idade >= 20 && idade <= 29) {
                        if (rcq.getRcq() < 0.83) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.83 && rcq.getRcq() <= 0.88) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.89 && rcq.getRcq() <= 0.94) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 0.94) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 30 && idade <= 39) {
                        if (rcq.getRcq() < 0.84) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.84 && rcq.getRcq() <= 0.91) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.92 && rcq.getRcq() <= 0.96) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 0.96) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 40 && idade <= 49) {
                        if (rcq.getRcq() < 0.88) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.88 && rcq.getRcq() <= 0.95) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.96 && rcq.getRcq() <= 1.0) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 1.0) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 50 && idade <= 59) {
                        if (rcq.getRcq() < 0.90) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.90 && rcq.getRcq() <= 0.96) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.97 && rcq.getRcq() <= 1.02) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 1.02) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 60 && idade <= 69) {
                        if (rcq.getRcq() < 0.91) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.91 && rcq.getRcq() <= 0.98) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.99 && rcq.getRcq() <= 1.03) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 1.03) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                } else {
                    //Feminino
                    if (idade >= 20 && idade <= 29) {
                        if (rcq.getRcq() < 0.71) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.71 && rcq.getRcq() <= 0.77) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.78 && rcq.getRcq() <= 0.82) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 0.82) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 30 && idade <= 39) {
                        if (rcq.getRcq() < 0.72) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.72 && rcq.getRcq() <= 0.78) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.79 && rcq.getRcq() <= 0.84) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 0.84) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 40 && idade <= 49) {
                        if (rcq.getRcq() < 0.73) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.73 && rcq.getRcq() <= 0.79) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.80 && rcq.getRcq() <= 0.87) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 0.87) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 50 && idade <= 59) {
                        if (rcq.getRcq() < 0.74) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.74 && rcq.getRcq() <= 0.81) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.82 && rcq.getRcq() <= 0.88) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 0.88) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }

                    if (idade >= 60 && idade <= 69) {
                        if (rcq.getRcq() < 0.76) rcq.setClassificacao("Baixo");
                        else if (rcq.getRcq() >= 0.76 && rcq.getRcq() <= 0.83) rcq.setClassificacao("Moderado");
                        else if (rcq.getRcq() >= 0.84 && rcq.getRcq() <= 0.90) rcq.setClassificacao("Alto");
                        else if (rcq.getRcq() > 0.90) rcq.setClassificacao("Muito Alto");
                        else rcq.setClassificacao("Fora da escala");
                    }
                }

                historicoRcq = sharedPreferencesUtil.getHistoricoRcq();
                historicoRcq.add(rcq);
                sharedPreferencesUtil.salvarHistoricoRcq(historicoRcq);

                Intent intent = new Intent(MainActivity.this, Resultado.class);

                intent.putExtra("nome", rcq.getNome());
                intent.putExtra("idade", rcq.getIdade().toString());
                intent.putExtra("sexo", rcq.getSexo());
                intent.putExtra("rcq", String.format("%.2f", rcq.getRcq()));
                intent.putExtra("classificacao", rcq.getClassificacao());

                startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("Não", null);
        alertDialog.show();
    }

    private void actionButtonHistoricoMain() {
        Intent intent = new Intent(MainActivity.this, Historico.class);
        startActivity(intent);
    }

    private void limpaCampos() {
        inputNomeMain.setText("");
        inputIdadeMain.setText("");
        inputCinturaMain.setText("");
        inputQuadrilMain.setText("");
        radioMasculino.setChecked(false);
        radioFeminino.setChecked(false);
    }
}