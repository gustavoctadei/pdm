package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bicicletariabikecenter.dao.BicicletaDao;
import com.example.bicicletariabikecenter.model.Bicicleta;
import com.example.bicicletariabikecenter.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {

    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.activity_favoritos);

        List<Bicicleta> listaBicicletasFavoritas = this.carregaFavoritos();

        ListView listViewFavoritos = findViewById(R.id.listViewFavoritos);

        ArrayAdapter<Bicicleta> arrayAdapter = new ArrayAdapter<Bicicleta>(this, android.R.layout.simple_list_item_1, listaBicicletasFavoritas);
        listViewFavoritos.setAdapter(arrayAdapter);

        listViewFavoritos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                visualizarBicicleta(listaBicicletasFavoritas.get(position).getId());
            }
        });
    }

    private List<Bicicleta> carregaFavoritos() {
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());
        List<Integer> listaFavoritos = sharedPreferencesUtil.getFavoritos();

        BicicletaDao bicicletaDao = new BicicletaDao(getApplicationContext());
        List<Bicicleta> listaBicicletas = bicicletaDao.listar();

        List<Bicicleta> listaBicicletasFavoritas = new ArrayList<>();

        for (Bicicleta b : listaBicicletas) {
            if (listaFavoritos.contains(b.getId()))
                listaBicicletasFavoritas.add(b);
        }

        return listaBicicletasFavoritas;
    }

    private void visualizarBicicleta(Integer id) {
        Intent intent = new Intent(FavoritosActivity.this, VisualizarBicicletaActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

}