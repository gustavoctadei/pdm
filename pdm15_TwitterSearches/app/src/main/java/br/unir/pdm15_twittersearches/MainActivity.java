package br.unir.pdm15_twittersearches;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private EditText editTextConsulta;
    private EditText editTextTag;
    private SharedPreferences sharedPreferences;
    private ArrayList<String> tags;
    private ArrayAdapter<String> arrayAdapter;
    private static final String SEARCHES = "searches";
    private ImageButton buttonSalvar;
    private ListView listaConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextConsulta = findViewById(R.id.editTextConsulta);
        editTextTag = findViewById(R.id.editTextTag);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        listaConsulta = findViewById(R.id.listaConsulta);

        sharedPreferences = getSharedPreferences(SEARCHES, MODE_PRIVATE);
        tags = new ArrayList<>( sharedPreferences.getAll().keySet() );
        Collections.sort(tags, String.CASE_INSENSITIVE_ORDER);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, tags);
        listaConsulta.setAdapter(arrayAdapter);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextConsulta.getText().toString().isEmpty() && !editTextTag.getText().toString().isEmpty()) {
                    String consulta = editTextConsulta.getText().toString();
                    String tag = editTextTag.getText().toString();

                    adicionarConsulta(consulta, tag);

                    editTextConsulta.getText().clear();
                    editTextTag.getText().clear();

                    ((InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            editTextTag.getWindowToken(), 0);

                } else {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Clique curto
        listaConsulta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String tag = ((TextView) view).getText().toString();
                String url = getString(R.string.searchURL) + Uri.encode( sharedPreferences.getString(tag, ""), "UTF-8");

                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(url) );
                startActivity(intent);
            }
        });

        //Clique longo
        listaConsulta.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String tag = ((TextView) view).getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.app_name);

                builder.setItems(R.array.dialog_items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                compartilharBusca(tag);
                                break;

                            case 1:
                                editTextTag.setText(tag);
                                break;

                            case 2:
                                removerBusca(tag);
                                break;
                        }
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.create().show();
                return true;
            }
        });
    }

    private void adicionarConsulta(String query, String tag) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(tag, query);
        editor.commit();

        if (!tags.contains(tag)) {
            tags.add(tag);
            Collections.sort(tags, String.CASE_INSENSITIVE_ORDER);

            arrayAdapter.notifyDataSetChanged();
        }
    }

    private void compartilharBusca(String tag) {
        String url = getString(R.string.searchURL) + Uri.encode( sharedPreferences.getString(tag, ""), "UTF-8");

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.shareSubject));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.shareMessage, url));
        intent.setType("text/plain");

        startActivity(Intent.createChooser(intent, getString(R.string.shareSearch)));
    }

    private void removerBusca(String tag) {
        AlertDialog.Builder confirmBuilder = new AlertDialog.Builder(MainActivity.this);
        confirmBuilder.setMessage(getString(R.string.confirmMessage, tag));

        confirmBuilder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        confirmBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tags.remove(tag);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(tag);
                editor.commit();

                arrayAdapter.notifyDataSetChanged();
            }
        });

        confirmBuilder.show();
    }

}