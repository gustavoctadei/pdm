package com.example.bicicletariabikecenter.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbUtil extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String NOME_DB = "bicicleta";
    public static final String TABELA_BICICLETA = "bicicleta";

    public DbUtil(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_BICICLETA +
                " (id INTEGER PRIMARY KEY," +
                " descricao TEXT NOT NULL," +
                " preco_dinheiro DOUBLE NOT NULL," +
                " preco_cartao DOUBLE NOT NULL);";

        try {
            sqLiteDatabase.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");

        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao criar a tabela: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_BICICLETA + " ;";

        try {
            sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
            Log.i("INFO DB", "Sucesso ao atualizar a tabela");

        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao atualizar a tabela: " + e.getMessage());
        }
    }
}
