package br.unir.pdm11_apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.criarFilmes();
        Adapter adapter = new Adapter(filmes);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), filmes.get(position).getTitulo(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(), filmes.get(position).getAno(), Toast.LENGTH_LONG).show();
                    }
                }));
    }

    public void criarFilmes() {
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        this.filmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2018");
        this.filmes.add(filme);

        filme = new Filme("Liga da Justiça", "Aventura", "2017");
        this.filmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2018");
        this.filmes.add(filme);

        filme = new Filme("X-Men: Fênix Negra", "Ficção", "2020");
        this.filmes.add(filme);

        filme = new Filme("Esquadrão Suicida", "Ação", "2019");
        this.filmes.add(filme);

        filme = new Filme("Um amor para recordar", "Romance", "2005");
        this.filmes.add(filme);

        filme = new Filme("O Jardim Secreto", "Drama", "1997");
        this.filmes.add(filme);

        filme = new Filme("Mudança de Hábito", "Comédia", "1994");
        this.filmes.add(filme);
    }
}