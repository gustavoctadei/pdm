package br.unir.pdm15_meufragmento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversas;
    private Button buttonContatos;

    private PrimeiroFragmento conversaFragmento;
    private SegundoFragmento contatoFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remover sombra da ActionBar
        getSupportActionBar().setElevation(0);

        conversaFragmento = new PrimeiroFragmento();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_conteudo, conversaFragmento);
        fragmentTransaction.commit();

        buttonContatos = findViewById(R.id.button_contatos);
        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatoFragmento = new SegundoFragmento();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_conteudo, contatoFragmento);
                fragmentTransaction.commit();
            }
        });

        buttonConversas = findViewById(R.id.button_conversas);
        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversaFragmento = new PrimeiroFragmento();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_conteudo, conversaFragmento);
                fragmentTransaction.commit();
            }
        });
    }
}