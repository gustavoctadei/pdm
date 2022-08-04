package com.example.bicicletariabikecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bicicletariabikecenter.R;
import com.example.bicicletariabikecenter.dao.BicicletaDao;
import com.example.bicicletariabikecenter.model.Bicicleta;

import java.util.ArrayList;
import java.util.List;

public class VisualizarBicicletaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_bicicleta);

        Intent intent = getIntent();
        Integer idBicicleta = intent.getIntExtra("id", 0);
        this.carregaImagem(idBicicleta);
        this.carregaDadosBicicleta(idBicicleta);
    }

    private void carregaDadosBicicleta(Integer id) {

        TextView textVisualizarBicicletaDescricao = findViewById(R.id.textVisualizarBicicletaDescricao);
        TextView textVisualizarBicicletaPrecoDinheiro = findViewById(R.id.textVisualizarBicicletaPrecoDinheiro);
        TextView textVisualizarBicicletaPrecoCartao = findViewById(R.id.textVisualizarBicicletaPrecoCartao);

        BicicletaDao bicicletaDao = new BicicletaDao(getApplicationContext());

        List<Bicicleta> listaBicicleta = new ArrayList<>();
        listaBicicleta = bicicletaDao.listar();

        for (Bicicleta b: listaBicicleta) {
            if (b.getId().equals(id)) {
                textVisualizarBicicletaDescricao.setText(b.getDescricao());
                textVisualizarBicicletaPrecoDinheiro.setText(b.getPrecoDinheiroFormatado());
                textVisualizarBicicletaPrecoCartao.setText(b.getPrecoCartaoFormatado());

                return;
            }
        }
    }

    private void carregaImagem(Integer id) {
        ImageView imageViewVisualizarBicicleta = findViewById(R.id.imageViewVisualizarBicicleta);

        switch (id) {
            case 1:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b1));
                break;

            case 2:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b2));
                break;

            case 3:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b3));
                break;

            case 4:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b4));
                break;

            case 5:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b5));
                break;

            case 6:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b6));
                break;

            case 7:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b7));
                break;

            case 8:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b8));
                break;

            case 9:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b9));
                break;

            case 10:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b10));
                break;

            case 11:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b11));
                break;

            case 12:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b12));
                break;

            case 13:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b13));
                break;

            case 14:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b14));
                break;

            case 15:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b15));
                break;

            case 16:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b16));
                break;

            case 17:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b17));
                break;

            case 18:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b18));
                break;

            case 19:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b19));
                break;

            case 20:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b20));
                break;

            case 21:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b21));
                break;

            case 22:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b22));
                break;

            case 23:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b23));
                break;

            case 24:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b24));
                break;

            case 25:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b25));
                break;

            case 26:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b26));
                break;

            case 27:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b27));
                break;

            case 28:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b28));
                break;

            case 29:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b29));
                break;

            case 30:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b30));
                break;

            case 31:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b31));
                break;

            case 32:
                imageViewVisualizarBicicleta.setImageDrawable(getDrawable(R.drawable.b32));
                break;
        }
    }
}