package br.unir.pdm14_riscocardiovascular;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Historico extends AppCompatActivity {

    private ListView listViewHistoricoRcq;
    private List<Rcq> historicoRcq;

    private SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        listViewHistoricoRcq = findViewById(R.id.listViewHistoricoRcq);

        sharedPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());

        historicoRcq = sharedPreferencesUtil.getHistoricoRcq();
        ArrayAdapter<Rcq> arrayAdapter = new ArrayAdapter<Rcq>(
                this,
                android.R.layout.simple_list_item_1,
                historicoRcq
        );

        listViewHistoricoRcq.setAdapter(arrayAdapter);

        listViewHistoricoRcq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Historico.this);
                alertDialog.setNeutralButton("Fechar", null);
                alertDialog.setTitle("Dados RCQ");

                Rcq rcqSelected = historicoRcq.get(position);
                String message = "Nome: " + rcqSelected.getNome() + "\n";
                message = message + "Idade: " + rcqSelected.getIdade().toString() + "\n";
                message = message + "Sexo: " + rcqSelected.getSexo() + "\n";
                message = message + "RCQ: " + String.format("%.2f", rcqSelected.getRcq()) + "\n";
                message = message + "Classificação: " + rcqSelected.getClassificacao();

                alertDialog.setMessage(message);
                alertDialog.show();
            }
        });

        listViewHistoricoRcq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int arg2, long arg3) {
                historicoRcq.remove(arg2);
                arrayAdapter.notifyDataSetChanged();

                sharedPreferencesUtil.salvarHistoricoRcq(historicoRcq);
                return false;
            }
        });

    }
}