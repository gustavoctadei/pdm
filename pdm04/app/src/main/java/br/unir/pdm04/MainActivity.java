package br.unir.pdm04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textoExibicao;
    private Button botaoAnterior;
    private Button botaoProximo;

    String [] noticias = {"A fundação da plataforma Android é o kernel do linux. Por exemplo: o Android Runtime (ART) " +
            "confia no kernel do Linux para cobrir funcionalidades como encadeamento e gerenciamento de memória de baixo " +
            "nível. Usar um kernel do Linux permite que o Android aproveite os recursos de segurança principais e que os " +
            "fabricantes dos dispositivos desenvolvam drivers de hardware para um kernel conhecido. A camada de abstração " +
            "de hardware (HAL) fornece interfaces padrão que expõem as capacidades de hardware do dispositivo para a " +
            "estrutura da Java API de maior nível. A HAL consiste em módulos de biblioteca, que implementam uma interface " +
            "para um tipo específico de componente de hardware, como o módulo de câmera ou Bluetooth. " +
            "Quando uma Framework API faz uma chamada para acessar o hardware do dispositivo, o sistema " +
            "Android carrega o módulo da biblioteca para este componente de hardware.",
            "Para dispositivos com Android versão 5.0 (API nível 21) ou mais recente, cada aplicativo executa o " +
                    "próprio processo com uma instância própria do Android Runtime (ART). O ART é projetado para " +
                    "executar várias máquinas virtuais em dispositivos de baixa memória executando arquivos DEX, um " +
                    "formato de bytecode projetado especialmente para Android, otimizado para oferecer consumo mínimo de memória. " +
                    "Construa cadeias de ferramentas, como Jack, e compile fontes Java em bytecodes DEX, que podem ser " +
                    "executadas na plataforma Android.",
            "Vários componentes e serviços principais do sistema Android, como ART e HAL, são implementados por " +
                    "código nativo que exige bibliotecas nativas programadas em C e C++. A plataforma Android fornece as " +
                    "Java Framework APIs para expor a funcionalidade de algumas dessas bibliotecas nativas aos aplicativos. " +
                    "Por exemplo, é possível acessar OpenGL ES pela Java OpenGL API da estrutura do Android para adicionar a " +
                    "capacidade de desenhar e manipular gráficos 2D e 3D no seu aplicativo.",
            "O Android vem com um conjunto de aplicativos principais para e-mail, envio de SMS, calendários, " +
                    "navegador de internet, contatos etc. Os aplicativos inclusos na plataforma não têm status especial " +
                    "entre os aplicativos que o usuário opta por instalar. Portanto, um aplicativo terceirizado pode se " +
                    "tornar o navegador da Web, o aplicativo de envio de SMS ou até mesmo o teclado padrão do usuário " +
                    "(existem algumas exceções, como o aplicativo Configurações do sistema)."
    };

    private int indice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoExibicao = findViewById(R.id.txt_exibicao);
        botaoAnterior = findViewById(R.id.btn_anterior);
        botaoProximo = findViewById(R.id.btn_proximo);

        botaoAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indice < 0) {
                    indice--;
                    textoExibicao.setText(noticias[indice]);
                }
            }
        });

        botaoProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indice < 0) {
                    indice++;
                    textoExibicao.setText(noticias[indice]);
                }
            }
        });
    }
}