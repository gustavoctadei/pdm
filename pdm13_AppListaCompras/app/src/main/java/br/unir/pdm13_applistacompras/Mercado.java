package br.unir.pdm13_applistacompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Mercado extends AppCompatActivity {

    private SharedPreferencesUtil sharedPreferencesUtil;
    private List<Produto> listaCompras;
    private List<Produto> carrinho;
    private FloatingActionButton buttonFinalizarMercado;
    private Float totalPrevisto;

    private ListView listViewMercado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado);

        carrinho = new ArrayList<Produto>();

        buttonFinalizarMercado = findViewById(R.id.buttonFinalizarMercado);
        listViewMercado = findViewById(R.id.listViewMercado);

        sharedPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());
        listaCompras = sharedPreferencesUtil.getListaCompras();
        totalPrevisto = calculaTotalPrevisto();

        ArrayAdapter<Produto> arrayAdapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, listaCompras);
        listViewMercado.setAdapter(arrayAdapter);

        listViewMercado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                compraProduto(listaCompras.get(position));
            }
        });

        listViewMercado.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int arg2, long arg3) {
                listaCompras.remove(arg2);
                arrayAdapter.notifyDataSetChanged();

                sharedPreferencesUtil.salvarListaCompras(listaCompras);

                Toast.makeText(getApplicationContext(), "O produto foi removido da lista de compras.", Toast.LENGTH_LONG).show();
                return false;
            }
        });


        buttonFinalizarMercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizarMercado();
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos privados
    ///////////////////////////////////////////////////////////////////////////////////////////////

    private void compraProduto(Produto p) {
        for (Produto produto : carrinho) {
            if (produto.getNome().equals( p.getNome() )) {
                if (produto.getQuantidade().equals(produto.getQuantidadeCarrinho())) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Mercado.this);
                    alertDialog.setTitle("Aviso!");
                    alertDialog.setMessage("Você já adicionou a quantidade prevista para este item. Deseja continuar e ultrapassar a quantidade prevista?");

                    alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            produto.setQuantidadeCarrinho( produto.getQuantidadeCarrinho() + 1 );
                        }
                    });

                    alertDialog.setNegativeButton("Não", null);
                    alertDialog.show();

                } else {
                    produto.setQuantidadeCarrinho( produto.getQuantidadeCarrinho() + 1 );
                }

                p = null;
            }
        }

        if (p != null) carrinho.add(p);
        Toast.makeText(getApplicationContext(), "O produto foi adicionado ao carrinho.", Toast.LENGTH_LONG).show();
    }

    private void finalizarMercado() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Mercado.this);
        alertDialog.setTitle("Carrinho");
        alertDialog.setNeutralButton("Ok", null);

        String carrinhoString = "";

        if (carrinho.isEmpty()) {
            carrinhoString = "O carrinho está vazio";

        } else {
            Float totalCarrinho = 0.0f;

            for (Produto p : carrinho) {
                carrinhoString = carrinhoString + p.getNome() + " - " + "Qtd: " + p.getQuantidadeCarrinho().toString() + " - "
                        + "R$" + String.format("%.2f", p.getQuantidadeCarrinho() * p.getPreco()) + "\n";
                totalCarrinho += p.getQuantidadeCarrinho() * p.getPreco();
            }

            carrinhoString = carrinhoString + "\n\n" + "TOTAL PREVISTO: R$" + String.format("%.2f", totalPrevisto) + "\n";
            carrinhoString = carrinhoString + "TOTAL: R$" + String.format("%.2f", totalCarrinho);
        }

        alertDialog.setMessage(carrinhoString);
        alertDialog.show();
    }

    private Float calculaTotalPrevisto() {
        Float totalPrevisto = 0.0f;
        for (Produto p : listaCompras) {
            totalPrevisto += p.getQuantidade() * p.getPreco();
        }

        return totalPrevisto;
    }

}