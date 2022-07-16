package br.unir.pdm19_geocalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalculaActivity extends AppCompatActivity {

    private Button buttonQuadrado, buttonRetangulo, buttonTriangulo;
    private FragmentoQuadrado fragmentoQuadrado;
    private FragmentoRetangulo fragmentoRetangulo;
    private FragmentoTriangulo fragmentoTriangulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula);

        //Remover sombra da ActionBar
        getSupportActionBar().setElevation(0);
        quadrado();

        buttonQuadrado = findViewById(R.id.button_quadrado);
        buttonQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quadrado();
            }
        });

        buttonRetangulo = findViewById(R.id.button_retangulo);
        buttonRetangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retangulo();
            }
        });

        buttonTriangulo = findViewById(R.id.button_triangulo);
        buttonTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                triangulo();
            }
        });

    }

    private void quadrado() {
        fragmentoQuadrado = new FragmentoQuadrado();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_conteudo, fragmentoQuadrado);
        fragmentTransaction.commit();
    }

    private void retangulo() {
        fragmentoRetangulo = new FragmentoRetangulo();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_conteudo, fragmentoRetangulo);
        fragmentTransaction.commit();
    }

    private void triangulo() {
        fragmentoTriangulo = new FragmentoTriangulo();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_conteudo, fragmentoTriangulo);
        fragmentTransaction.commit();
    }
}