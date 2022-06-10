package br.unir.pdm09_appnotas;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private static final String NOME_ARQUIVO = "anotacao";
    private static final String CHAVE = "nota";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private Context context;

    public AnotacaoPreferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvar(String anotacao) {
        editor.putString(CHAVE, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao() {
        return preferences.getString(CHAVE, "");
    }

}
