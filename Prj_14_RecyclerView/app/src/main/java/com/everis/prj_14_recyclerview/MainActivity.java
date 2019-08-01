package com.everis.prj_14_recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.everis.mylibrary.ToolBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView rv_nomes;
    private Adapter_Nomes adapter_nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = MainActivity.this;
        //
        rv_nomes = findViewById(R.id.rv_nomes);
        rv_nomes.setLayoutManager(new LinearLayoutManager(context));
        //
        adapter_nomes = new Adapter_Nomes(
                context,
                R.layout.celula,
                gerarNomes(10)
        );
        //
        adapter_nomes.setOnItemClickListener(new Adapter_Nomes.ItemClickListener() {
            @Override
            public void onItemClick(int position, HMAux item) {
                Toast.makeText(
                        context,
                        item.get(Constantes.NOME),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        //

        rv_nomes.setAdapter(adapter_nomes);

    }

    private void inicializarAcao() {

    }

    private ArrayList<HMAux> gerarNomes(int quantidade) {
        ArrayList<HMAux> nomes = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux aux = new HMAux();

            aux.put(Constantes.ID, String.valueOf(i));
            aux.put(Constantes.NOME, "Nome - " + String.valueOf(i));

            nomes.add(aux);
        }
        //
        return nomes;
    }
}
