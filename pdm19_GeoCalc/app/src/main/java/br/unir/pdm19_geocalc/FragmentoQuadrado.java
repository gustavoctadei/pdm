package br.unir.pdm19_geocalc;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoQuadrado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoQuadrado extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button buttonCalcularQuadrado;

    public FragmentoQuadrado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoQuadrado.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoQuadrado newInstance(String param1, String param2) {
        FragmentoQuadrado fragment = new FragmentoQuadrado();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_quadrado, container, false);

        EditText editTextLadoQuadrado = view.findViewById(R.id.edit_text_lado_quadrado);

        buttonCalcularQuadrado = view.findViewById(R.id.button_calcular_quadrado);
        buttonCalcularQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = "";

                if (editTextLadoQuadrado.getText().toString().isEmpty()) {
                    mensagem = "É necessário preencher todos os campos.";
                }

                else {
                    Float ladoQuadrado = Float.valueOf( editTextLadoQuadrado.getText().toString() );

                    if (ladoQuadrado <= 0) {
                        mensagem = "Valor informado inválido.";
                    }

                    else {
                        Float areaQuadrado = ladoQuadrado * ladoQuadrado;
                        mensagem = "A área do quadrado é: " + areaQuadrado;

                        editTextLadoQuadrado.getText().clear();
                    }
                }

                AlertDialog.Builder janela = new AlertDialog.Builder(view.getContext());
                janela.setTitle("Área do Quadrado");
                janela.setMessage(mensagem);

                janela.setNeutralButton("OK", null);
                janela.show();
            }
        });

        return view;
    }

}