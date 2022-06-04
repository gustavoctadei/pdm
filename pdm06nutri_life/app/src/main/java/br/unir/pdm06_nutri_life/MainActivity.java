package br.unir.pdm06_nutri_life;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextPeso;
    private EditText editTextAltura;
    private RadioButton radioMasculino;
    private RadioButton radioFeminino;
    private RadioGroup radioGroupSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextPeso = findViewById(R.id.edit_text_peso);
        editTextAltura = findViewById(R.id.edit_text_altura);
        radioMasculino = findViewById(R.id.radio_masculino);
        radioFeminino = findViewById(R.id.radio_feminino);
        radioGroupSexo = findViewById(R.id.radio_group_sexo);

        Button botaoCalcular = findViewById(R.id.botao_calcular);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoCalcularAction();
            }
        });

    }

    public void botaoCalcularAction() {
        Boolean camposOk = true;

        if (editTextNome.getText().toString().isEmpty() || editTextNome.getText() == null) {
            camposOk = false;
        }

        if (editTextPeso.getText().toString().isEmpty() || editTextPeso.getText() == null) {
            camposOk = false;
        }

        if (editTextAltura.getText().toString().isEmpty() || editTextAltura.getText() == null) {
            camposOk = false;
        }

        if (!radioMasculino.isChecked() && !radioFeminino.isChecked()) {
            camposOk = false;
        }

        if (!camposOk) {
            AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
            janela.setTitle("Erro");
            janela.setMessage("É necessário preeencher todos os campos.");
            janela.setNeutralButton("Fechar", null);
            janela.show();
        }

        if (camposOk) {

            String nome = "Olá, " + editTextNome.getText().toString();

            Float peso = Float.parseFloat(editTextPeso.getText().toString());

            Float altura = Float.parseFloat(editTextAltura.getText().toString());

            Integer idRadioSexoSelected = radioGroupSexo.getCheckedRadioButtonId();
            RadioButton radioSexo = findViewById(idRadioSexoSelected);
            String sexo = radioSexo.getText().toString();

            Map<String, String> dadosImc = new HashMap<>();
            dadosImc = calcularImc(peso, altura, sexo);

            Intent intent = new Intent(MainActivity.this, Resultado.class);

            intent.putExtra("nome", nome);
            intent.putExtra("imc", dadosImc.get("imc"));
            intent.putExtra("classificacao", dadosImc.get("classificacao"));
            intent.putExtra("riscos", dadosImc.get("riscos"));

            startActivity(intent);
        }
    }

    public Map<String, String> calcularImc(Float peso, Float altura, String sexo) {
        Map<String, String> toReturn = new HashMap<>();

        Float imc = peso / (altura*altura);

        String classificacao = "Classificação: ";
        if  (sexo.equals("Masculino")) {
            if (imc > 43) classificacao = classificacao + "Obesidade Mórbida";
            else if (imc <= 43 && imc >= 30) classificacao = classificacao + "Obesidade Moderada";
            else if (imc < 30 && imc >= 25) classificacao = classificacao + "Obesidade Leve";
            else if (imc < 25 && imc >= 20) classificacao = classificacao + "Normal";
            else if (imc < 20 && imc >= 0) classificacao = classificacao + "Abaixo do Normal";
            else classificacao = "Erro ao Calcular o IMC";
        }

        else if (sexo.equals("Feminino")) {
            if (imc > 39) classificacao = classificacao + "Obesidade Mórbida";
            else if (imc <= 39 && imc >= 29) classificacao = classificacao + "Obesidade Moderada";
            else if (imc < 29 && imc >= 24) classificacao = classificacao + "Obesidade Leve";
            else if (imc < 24 && imc >= 19) classificacao = classificacao + "Normal";
            else if (imc < 19 && imc >= 0) classificacao = classificacao + "Abaixo do Normal";
            else classificacao = "Erro ao Calcular o IMC";
        }

        String riscos = "";
        if (imc > 40) riscos = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC";
        else if (imc <= 40 && imc >= 35) riscos = "Apneia do sono, falta de ar";
        else if (imc < 35 && imc >= 30) riscos = "Diabetes, angina, infarto, aterosclerose";
        else if (imc < 30 && imc >= 25) riscos = "Fadia, má circulação, varizes";
        else if (imc < 25 && imc >= 18.5) riscos = "Menor risco de doenças cardíacas e vasculares";
        else if (imc < 18.5 && imc >= 17) riscos = "Fadiga, stress, ansiedade";
        else if (imc < 17 && imc >= 16) riscos = "Queda de cabelo, infertilidade, ausência menstrual";
        else if (imc < 16) riscos = "Abaixo da referência";

        toReturn.put("imc", "Seu IMC é: " + String.format("%.2f", imc));
        toReturn.put("classificacao", classificacao);
        toReturn.put("riscos", riscos);

        return toReturn;
    }

}