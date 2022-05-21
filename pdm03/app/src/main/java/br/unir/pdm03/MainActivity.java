package br.unir.pdm03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoPremio;

    private Button botaoSortear;

    private Integer premioSorteado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoPremio = findViewById(R.id.textoPremio);
        botaoSortear = findViewById(R.id.botaoSortear);

        botaoSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                Integer premioSorteado = random.nextInt(9);

                textoPremio.setText("Seu prêmio é: ");

                switch (premioSorteado) {
                    case 0:
                        textoPremio.setText(textoPremio.getText() + "R$1.0000");
                        break;

                    case 1:
                        textoPremio.setText(textoPremio.getText() + "R$2.000");
                        break;

                    case 2:
                        textoPremio.setText(textoPremio.getText() + "R$100.000");
                        break;

                    case 3:
                        textoPremio.setText(textoPremio.getText() + "Carro 0KM");
                        break;

                    case 4:
                        textoPremio.setText(textoPremio.getText() + "Motocicleta");
                        break;

                    case 5:
                        textoPremio.setText(textoPremio.getText() + "Casa");
                        break;

                    case 6:
                        textoPremio.setText(textoPremio.getText() + "Viagem");
                        break;

                    case 7:
                        textoPremio.setText(textoPremio.getText() + "Smartphone");
                        break;

                    case 8:
                        textoPremio.setText(textoPremio.getText() + "Apartamento");
                        break;
                }
            }
        });
    }
}