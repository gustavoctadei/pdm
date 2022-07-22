package br.unir.pdm_18_listatarefasapp.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.unir.pdm_18_listatarefasapp.model.Tarefa;

public class TarefaDao implements ITarefaDao {

    private SQLiteDatabase escrita;
    private SQLiteDatabase leitura;

    public TarefaDao(Context context) {
        DbHelper db = new DbHelper(context);

        escrita = db.getWritableDatabase();
        leitura = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            escrita.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.i("INFO", "Tarefa salva com sucesso.");

        } catch (Exception e) {
            Log.i("INFO", "Erro ao salvar tarefa: " + e.getMessage());
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            String [] args = {String.valueOf(tarefa.getId())};
            escrita.update(DbHelper.TABELA_TAREFAS, cv, "id = ?", args);
            Log.i("INFO", "Tarefa atualizada com sucesso.");

        } catch (Exception e) {
            Log.i("INFO", "Erro ao atualizar tarefa.");
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        try {
            String [] args = {String.valueOf(tarefa.getId())};
            escrita.delete(DbHelper.TABELA_TAREFAS, "id = ?", args);
            Log.i("INFO", "Tarefa removida com sucesso.");

        } catch (Exception e) {
            Log.i("INFO", "Erro ao remover tarefa.");
            return false;
        }

        return true;
    }

    @SuppressLint("Range")
    @Override
    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor c = leitura.rawQuery(sql, null);

        while (c.moveToNext()) {
            Tarefa tarefa = new Tarefa();
            tarefa.setId( c.getLong( c.getColumnIndex("id") ) );
            tarefa.setNomeTarefa( c.getString( c.getColumnIndex("nome") ) );

            tarefas.add(tarefa);
        }

        return tarefas;
    }
}
