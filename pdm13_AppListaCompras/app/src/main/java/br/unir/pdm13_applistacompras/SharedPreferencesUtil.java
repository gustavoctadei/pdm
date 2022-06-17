package br.unir.pdm13_applistacompras;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesUtil {

    private static final String NOME_ARQUIVO = "lista_compras";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private Context context;

    public SharedPreferencesUtil(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvarListaCompras(List<Produto> listaCompras) {
        limparListaCompras();

        for (Integer i = 0; i < listaCompras.size(); i++) {
            editor.putString("nomeProduto" + i.toString(), listaCompras.get(i).getNome());
            editor.putInt("quantidadeProduto" + i.toString(), listaCompras.get(i).getQuantidade());
            editor.putFloat("precoProduto" + i.toString(), listaCompras.get(i).getPreco());
        }

        editor.commit();
    }

    public List<Produto> getListaCompras() {
        Integer i = 0;
        List<Produto> listaCompras = new ArrayList<>();

        while (preferences.contains("nomeProduto" + i.toString())) {
            Produto p = new Produto();
            p.setNome( preferences.getString("nomeProduto" + i.toString(), "") );
            p.setQuantidade( preferences.getInt("quantidadeProduto" + i.toString(), 0) );
            p.setPreco( preferences.getFloat("precoProduto" + i.toString(), 0) );

            listaCompras.add(p);

            i++;
        }

        return listaCompras;
    }

    public void limparListaCompras() {
        editor.clear();
        editor.commit();
    }
}
