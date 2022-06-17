package br.unir.pdm13_applistacompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Mercado extends AppCompatActivity {

    private RecyclerView recyclerViewMercado;

    private SharedPreferencesUtil sharedPreferencesUtil;
    private List<Produto> listaCompras;
    private List<Produto> carrinho;
    private FloatingActionButton buttonFinalizarMercado;
    private Float totalPrevisto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado);

        carrinho = new ArrayList<Produto>();

        buttonFinalizarMercado = findViewById(R.id.buttonFinalizarMercado);

        sharedPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());
        listaCompras = sharedPreferencesUtil.getListaCompras();
        totalPrevisto = calculaTotalPrevisto();

        ProdutoAdapter produtoAdapter = new ProdutoAdapter(listaCompras);

        recyclerViewMercado = findViewById(R.id.recyclerViewMercado);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Mercado.this);
        recyclerViewMercado.setLayoutManager(layoutManager);
        recyclerViewMercado.setHasFixedSize(true);
        recyclerViewMercado.addItemDecoration( new DividerItemDecoration( Mercado.this, LinearLayout.VERTICAL) );
        recyclerViewMercado.setAdapter(produtoAdapter);

        recyclerViewMercado.addOnItemTouchListener(new RecyclerItemClickListener(Mercado.this, recyclerViewMercado,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onItemClick(View view, int position) {
                        compraProduto(listaCompras.get(position));
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));

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