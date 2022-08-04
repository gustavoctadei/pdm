package com.example.bicicletariabikecenter.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bicicletariabikecenter.model.Bicicleta;
import com.example.bicicletariabikecenter.util.DbUtil;

import java.util.ArrayList;
import java.util.List;

public class BicicletaDao {

    private SQLiteDatabase escrita;
    private SQLiteDatabase leitura;

    public BicicletaDao(Context context) {
        DbUtil db = new DbUtil(context);

        escrita = db.getWritableDatabase();
        leitura = db.getReadableDatabase();
    }

    public Boolean salvar(Bicicleta bicicleta) {
        ContentValues cv = new ContentValues();
        cv.put("id", bicicleta.getId());
        cv.put("descricao", bicicleta.getDescricao());
        cv.put("preco_dinheiro", bicicleta.getPrecoDinheiro());
        cv.put("preco_cartao", bicicleta.getPrecoCartao());

        try {
            escrita.insert(DbUtil.TABELA_BICICLETA, null, cv);
            Log.i("INFO", "Bicicleta salva com sucesso.");

        } catch (Exception e) {
            Log.i("INFO", "Erro ao salvar bicicleta: " + e.getMessage());
        }

        return true;
    }

    @SuppressLint("Range")
    public List<Bicicleta> listar() {
        List<Bicicleta> bicicletas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbUtil.TABELA_BICICLETA + " ;";
        Cursor c = leitura.rawQuery(sql, null);

        while (c.moveToNext()) {
            Bicicleta bicicleta = new Bicicleta();
            bicicleta.setId( c.getInt( c.getColumnIndex("id") ) );
            bicicleta.setDescricao( c.getString( c.getColumnIndex("descricao") ) );
            bicicleta.setPrecoDinheiro( c.getDouble( c.getColumnIndex("preco_dinheiro") ) );
            bicicleta.setPrecoCartao( c.getDouble( c.getColumnIndex("preco_cartao") ) );

            bicicletas.add(bicicleta);
        }

        return bicicletas;
    }

    public void inserirBicicletas() {
        Bicicleta b = new Bicicleta();
        b.setId(1);
        b.setDescricao("Bicicleta aro 12\n" +
                "Cor Violeta/Rosa \n" +
                "Neon");
        b.setPrecoDinheiro(280.0);
        b.setPrecoCartao(300.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(2);
        b.setDescricao("Bicicleta aro 12\n" +
                "Cor Verde/Preta");
        b.setPrecoDinheiro(280.0);
        b.setPrecoCartao(300.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(3);
        b.setDescricao("Bicicleta aro 12\n" +
                "Cor Rosa/Azul");
        b.setPrecoDinheiro(280.0);
        b.setPrecoCartao(300.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(4);
        b.setDescricao("Bicicleta aro 12\n" +
                "Cor Azul/Preta");
        b.setPrecoDinheiro(330.0);
        b.setPrecoCartao(350.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(5);
        b.setDescricao("Bicicleta aro 12\n" +
                "Cor \n" +
                "Vermelha/Amarela");
        b.setPrecoDinheiro(330.0);
        b.setPrecoCartao(350.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(6);
        b.setDescricao("Bicicleta aro 12\n" +
                "Cor Rosa/Violeta");
        b.setPrecoDinheiro(330.0);
        b.setPrecoCartao(350.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(7);
        b.setDescricao("Bicicleta aro 16\n" +
                "Cor Rosa Pink");
        b.setPrecoDinheiro(650.0);
        b.setPrecoCartao(680.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(8);
        b.setDescricao("Bicicleta aro 16\n" +
                "Cor Preta/Rosa Pink");
        b.setPrecoDinheiro(650.0);
        b.setPrecoCartao(680.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(9);
        b.setDescricao("Bicicleta aro 16\n" +
                "Cor Lilás");
        b.setPrecoDinheiro(650.0);
        b.setPrecoCartao(680.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(10);
        b.setDescricao("Bicicleta aro 16\n" +
                "Cor Preta/verde");
        b.setPrecoDinheiro(650.0);
        b.setPrecoCartao(680.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(11);
        b.setDescricao("Bicicleta aro 16\n" +
                "Cor Vermelha");
        b.setPrecoDinheiro(650.0);
        b.setPrecoCartao(680.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(12);
        b.setDescricao("Bicicleta aro 16\n" +
                "Cor Rosa/Branca");
        b.setPrecoDinheiro(650.0);
        b.setPrecoCartao(680.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(13);
        b.setDescricao("Bicicleta aro 20\n" +
                "Cor Verde Neon");
        b.setPrecoDinheiro(750.0);
        b.setPrecoCartao(780.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(14);
        b.setDescricao("Bicicleta aro 20\n" +
                "Cor Vermelha");
        b.setPrecoDinheiro(750.0);
        b.setPrecoCartao(780.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(15);
        b.setDescricao("Bicicleta aro 20\n" +
                "Cor Lilás");
        b.setPrecoDinheiro(750.0);
        b.setPrecoCartao(780.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(16);
        b.setDescricao("Bicicleta aro 20\n" +
                "Cor Rosa");
        b.setPrecoDinheiro(750.0);
        b.setPrecoCartao(780.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(17);
        b.setDescricao("Bicicleta aro 20\n" +
                "Cor Branca/Rosa");
        b.setPrecoDinheiro(750.0);
        b.setPrecoCartao(780.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(18);
        b.setDescricao("Bicicleta aro 20\n" +
                "Cor Azul Piscina");
        b.setPrecoDinheiro(750.0);
        b.setPrecoCartao(780.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(19);
        b.setDescricao("Bicicleta aro 24\n" +
                "Cor Verde");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(20);
        b.setDescricao("Bicicleta aro 24\n" +
                "Cor Lilás");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(21);
        b.setDescricao("Bicicleta aro 24\n" +
                "Cor Azul");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(22);
        b.setDescricao("Bicicleta aro 24\n" +
                "Cor Rosa");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(23);
        b.setDescricao("Bicicleta aro 26\n" +
                "Cor Laranja");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(24);
        b.setDescricao("Bicicleta aro 26\n" +
                "Cor Lilás");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(25);
        b.setDescricao("Bicicleta aro 26\n" +
                "Cor Azul Piscina");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(26);
        b.setDescricao("Bicicleta aro 26\n" +
                "Cor Rosa");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(27);
        b.setDescricao("Bicicleta aro 26\n" +
                "Cor Azul modelo \n" +
                "Monark");
        b.setPrecoDinheiro(850.0);
        b.setPrecoCartao(900.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(28);
        b.setDescricao("Bicicleta aro 26\n" +
                "Cor azul modelo\n" +
                "Cargueira");
        b.setPrecoDinheiro(1400.0);
        b.setPrecoCartao(1500.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(29);
        b.setDescricao("Bicicleta aro 29\n" +
                "Cor Vermelha");
        b.setPrecoDinheiro(1900.0);
        b.setPrecoCartao(2000.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(30);
        b.setDescricao("Bicicleta aro 29\n" +
                "Cor \n" +
                "Preta/Laranja");
        b.setPrecoDinheiro(1900.0);
        b.setPrecoCartao(2000.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(31);
        b.setDescricao("Bicicleta aro 29\n" +
                "Cor Preta/Verde");
        b.setPrecoDinheiro(1900.0);
        b.setPrecoCartao(2000.0);
        this.salvar(b);

        b = new Bicicleta();
        b.setId(32);
        b.setDescricao("Bicicleta aro 29\n" +
                "Cor Violeta");
        b.setPrecoDinheiro(1900.0);
        b.setPrecoCartao(2000.0);
        this.salvar(b);
    }
}
