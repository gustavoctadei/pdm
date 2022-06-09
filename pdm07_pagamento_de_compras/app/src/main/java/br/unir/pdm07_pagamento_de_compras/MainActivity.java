package br.unir.pdm07_pagamento_de_compras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private CheckBox boxArroz;
    private CheckBox boxCarne;
    private CheckBox boxPao;
    private CheckBox boxLeite;
    private CheckBox boxOvos;

    private Button botaoTotal;
    private TextView textoValor;
    private Double total;

    private RadioGroup radioGroupDesconto;

    private EditText editTextValorPago;
    private Button botaoEfetuarPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTotal = findViewById(R.id.botaoTotal);

        botaoEfetuarPagamento = findViewById(R.id.botaoEfetuarPagamento);

        botaoTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = calculaValorTotal();
            }
        });

        botaoEfetuarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efetuarPagamento();
            }
        });
    }

    private Double calculaValorTotal() {
        Double valorTotal = 0.0;

        boxArroz = findViewById(R.id.boxArroz);
        boxCarne = findViewById(R.id.boxCarne);
        boxPao = findViewById(R.id.boxPao);
        boxLeite = findViewById(R.id.boxLeite);
        boxOvos = findViewById(R.id.boxOvos);

        textoValor = findViewById(R.id.textoValor);

        if (boxArroz.isChecked()) valorTotal += 3.5;
        if (boxCarne.isChecked()) valorTotal += 12.3;
        if (boxPao.isChecked()) valorTotal += 2.2;
        if (boxLeite.isChecked()) valorTotal += 5.5;
        if (boxOvos.isChecked()) valorTotal += 7.5;

        textoValor.setText(String.format("Valor: R$%.2f", valorTotal));

        return valorTotal;
    }

    public void efetuarPagamento() {
        Double totalAposDesconto = total;

        radioGroupDesconto = findViewById(R.id.radioGroupDesconto);

        Integer idRadioDescontoSelected = radioGroupDesconto.getCheckedRadioButtonId();
        RadioButton radioDescontoSelected = findViewById(idRadioDescontoSelected);
        String descontoSelected = radioDescontoSelected.getText().toString();

        switch (descontoSelected) {
            case "5%":
                totalAposDesconto = totalAposDesconto * 0.95;
                break;

            case "10%":
                totalAposDesconto = totalAposDesconto * 0.90;
                break;

            case "15%":
                totalAposDesconto = totalAposDesconto * 0.85;
                break;
        }

        AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
        janela.setTitle("Aviso");
        janela.setNeutralButton("Ok", null);

        editTextValorPago = findViewById(R.id.editTextValorPago);

        if (editTextValorPago.getText().toString().isEmpty()) {
            janela.setMessage("É necessário informar um valor.");
        }
        else {
            Double valorPago = Double.parseDouble(editTextValorPago.getText().toString());

            if (valorPago < totalAposDesconto) {
                janela.setMessage("Valor incompatível com a compra.");
            }

            else {
                String mensagem = String.format("Valor total da compra: R$%.2f \n", totalAposDesconto);
                mensagem = mensagem + "Desconto: " + descontoSelected + " \n";
                mensagem = mensagem + String.format("Valor pago: %.2f \n", valorPago);
                mensagem = mensagem + String.format("Troco: R$%.2f", (valorPago - totalAposDesconto));

                janela.setMessage(mensagem);
            }
        }

        janela.show();
    }

}