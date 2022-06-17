package br.unir.pdm14_riscocardiovascular;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesUtil {
    private static final String NOME_ARQUIVO = "rcq";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private Context context;

    public SharedPreferencesUtil(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvarHistoricoRcq(List<Rcq> historicoRcq) {
        limparHistorico();

        for (Integer i = 0; i < historicoRcq.size(); i++) {
            editor.putString("nome" + i.toString(), historicoRcq.get(i).getNome());
            editor.putInt("idade" + i.toString(), historicoRcq.get(i).getIdade());
            editor.putString("sexo" + i.toString(), historicoRcq.get(i).getSexo());
            editor.putFloat("rcq" + i.toString(), historicoRcq.get(i).getRcq());
            editor.putString("classificacao" + i.toString(), historicoRcq.get(i).getClassificacao());
        }

        editor.commit();
    }

    public List<Rcq> getHistoricoRcq() {
        Integer i = 0;
        List<Rcq> historicoRcq = new ArrayList<>();

        while (preferences.contains("nome" + i.toString())) {
            Rcq rcq = new Rcq();
            rcq.setNome( preferences.getString("nome" + i.toString(), "") );
            rcq.setIdade( preferences.getInt("idade" + i.toString(), 0) );
            rcq.setSexo( preferences.getString("sexo" + i.toString(), "") );
            rcq.setRcq( preferences.getFloat("rcq" + i.toString(), 0) );
            rcq.setClassificacao( preferences.getString("classificacao" + i.toString(), "") );

            historicoRcq.add(rcq);

            i++;
        }

        return historicoRcq;
    }

    public void limparHistorico() {
        editor.clear();
        editor.commit();
    }
}
