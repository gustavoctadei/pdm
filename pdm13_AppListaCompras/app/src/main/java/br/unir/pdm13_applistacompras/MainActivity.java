package br.unir.pdm13_applistacompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputNomeProdutoMain;
    private EditText inputQuantidadeProdutoMain;
    private EditText inputPrecoProdutoMain;

    private SharedPreferencesUtil sharedPreferencesUtil;
    private List<Produto> listaCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());
        listaCompras = sharedPreferencesUtil.getListaCompras();

        Button buttonAdicionarMain = findViewById(R.id.buttonAdicionarMain);
        Button buttonLimparMain = findViewById(R.id.buttonLimparMain);
        Button buttonVisualizarMain = findViewById(R.id.buttonVisualizarMain);
        Button buttonAvancarMain = findViewById(R.id.buttonAvancarMain);

        buttonAdicionarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionButtonAdicionarMain();
            }
        });

        buttonLimparMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionButtonLimparMain();
            }
        });

        buttonVisualizarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionButtonVisualizarMain();
            }
        });

        buttonAvancarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionButtonAvancarMain();
            }
        });
    }

    public void actionButtonAdicionarMain() {
        EditText inputNomeProdutoMain = findViewById(R.id.inputNomeProdutoMain);
        EditText inputQuantidadeProdutoMain = findViewById(R.id.inputQuantidadeProdutoMain);
        EditText inputPrecoProdutoMain = findViewById(R.id.inputPrecoProdutoMain);

        if (inputNomeProdutoMain.getText().toString().isEmpty()
                || inputQuantidadeProdutoMain.getText().toString().isEmpty()
                || inputPrecoProdutoMain.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "É necessário preencher todos os dados do produto!", Toast.LENGTH_LONG).show();
            return;
        }

        Produto p = new Produto();
        p.setNome( inputNomeProdutoMain.getText().toString() );
        p.setQuantidade( Integer.valueOf( inputQuantidadeProdutoMain.getText().toString()) );
        p.setPreco( Float.valueOf( inputPrecoProdutoMain.getText().toString() ) );

        listaCompras.add(p);
        sharedPreferencesUtil.salvarListaCompras(listaCompras);

        limparCampos();

        Toast.makeText(getApplicationContext(), "Produto Salvo com sucesso!", Toast.LENGTH_LONG).show();
    }

    public void actionButtonLimparMain() {
        listaCompras = new ArrayList<>();
        sharedPreferencesUtil.limparListaCompras();

        Toast.makeText(getApplicationContext(), "A lista de compras foi esvaziada.", Toast.LENGTH_LONG).show();
    }

    public void actionButtonVisualizarMain() {
        listaCompras = sharedPreferencesUtil.getListaCompras();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Lista de Compras");
        alertDialog.setNeutralButton("Ok", null);

        String listaComprasString = "";

        if (listaCompras.isEmpty()) {
            listaComprasString = "A lista de compras está vazia.";

        } else {
            Float totalValorCompra = 0.0f;

            for (Produto p : listaCompras) {
                listaComprasString = listaComprasString + p.toString() + "\n";
                totalValorCompra += p.getQuantidade() * p.getPreco();
            }

            listaComprasString = listaComprasString + "\n\n" + "TOTAL: R$" + String.format("%.2f", totalValorCompra);
        }

        alertDialog.setMessage(listaComprasString);
        alertDialog.show();
    }

    public void actionButtonAvancarMain() {
        Intent intent = new Intent(MainActivity.this, Mercado.class);
        startActivity(intent);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Métodos privados
    ///////////////////////////////////////////////////////////////////////////////////////////////

    private void limparCampos() {
        EditText inputNomeProdutoMain = findViewById(R.id.inputNomeProdutoMain);
        EditText inputQuantidadeProdutoMain = findViewById(R.id.inputQuantidadeProdutoMain);
        EditText inputPrecoProdutoMain = findViewById(R.id.inputPrecoProdutoMain);

        inputNomeProdutoMain.setText("");
        inputQuantidadeProdutoMain.setText("");
        inputPrecoProdutoMain.setText("");
    }

}