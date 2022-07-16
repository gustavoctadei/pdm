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
 * Use the {@link FragmentoRetangulo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoRetangulo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoRetangulo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoRetangulo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoRetangulo newInstance(String param1, String param2) {
        FragmentoRetangulo fragment = new FragmentoRetangulo();
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
        View view = inflater.inflate(R.layout.fragment_fragmento_retangulo, container, false);

        EditText editTextBaseRetangulo = view.findViewById(R.id.edit_text_base_retangulo);
        EditText editTextLadoRetangulo = view.findViewById(R.id.edit_text_lado_retangulo);

        Button buttonCalcularRetangulo = view.findViewById(R.id.button_calcular_retangulo);
        buttonCalcularRetangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = "";

                if (editTextBaseRetangulo.getText().toString().isEmpty()
                    || editTextLadoRetangulo.getText().toString().isEmpty()) {
                    mensagem = "É necessário preencher todos os campos.";
                }

                else {
                    Float baseRetangulo = Float.valueOf( editTextBaseRetangulo.getText().toString() );
                    Float ladoRetangulo = Float.valueOf( editTextLadoRetangulo.getText().toString() );

                    if ( (baseRetangulo <= 0 || ladoRetangulo <= 0) || (baseRetangulo <= ladoRetangulo) ) {
                        mensagem = "Valores informados inválidos.";
                    }

                    else {
                        Float areaRetangulo = baseRetangulo * ladoRetangulo;
                        mensagem = "A área de retângulo é: " + areaRetangulo;

                        editTextBaseRetangulo.getText().clear();
                        editTextLadoRetangulo.getText().clear();
                    }
                }

                AlertDialog.Builder janela = new AlertDialog.Builder(view.getContext());
                janela.setTitle("Área do Retângulo");
                janela.setMessage(mensagem);

                janela.setNeutralButton("OK", null);
                janela.show();
            }
        });

        return view;
    }
}