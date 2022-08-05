package com.example.bicicletariabikecenter.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.bicicletariabikecenter.model.Bicicleta;

import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesUtil {

    private static final String NOME_ARQUIVO = "bicicleta-favoritos";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private Context context;

    public SharedPreferencesUtil(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void adicionarFavorito(Integer id) {
        List<Integer> listaFavoritos = this.getFavoritos();

        if (!listaFavoritos.contains(id)) {
            listaFavoritos.add(id);
            this.salvarFavoritos(listaFavoritos);
        }
    }

    public void removerFavorito(Integer id) {
        List<Integer> listaFavoritos = this.getFavoritos();

        if (listaFavoritos.contains(id)) {
            listaFavoritos.remove(id);
            this.salvarFavoritos(listaFavoritos);
        }
    }

    public List<Integer> getFavoritos() {
        Integer i = 0;
        List<Integer> listaFavoritos = new ArrayList<>();

        for (i = 1; i <= 32; i++) {
            if (preferences.contains("b" + i.toString()))
                listaFavoritos.add(i);
        }

        return listaFavoritos;
    }

    private void salvarFavoritos(List<Integer> listaFavoritos) {
        this.limparFavoritos();

        for (Integer i : listaFavoritos) {
            editor.putInt("b" + i.toString(), 1);
        }

        editor.commit();
    }

    private void limparFavoritos() {
        editor.clear();
        editor.commit();
    }

}
