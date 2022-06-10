package br.unir.pdm10_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaCidades;
    private String [] cidades = {
            "Porto Velho", "Ariquemes", "Ji-Paraná",
            "Vilhena", "Cacoal", "Rolim de Moura",
            "Jaru", "Ouro Preto do Oeste", "Buritis",
            "Theobroma", "Mirante da Serra", "Monte Negro",
            "Candeias do Jamari", "Costa Marques", "Colorado do Oeste"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCidades = findViewById(R.id.listaCidades);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, cidades);
        listaCidades.setAdapter(adapter);

        listaCidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valorSelecionado = listaCidades.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });

    }
}