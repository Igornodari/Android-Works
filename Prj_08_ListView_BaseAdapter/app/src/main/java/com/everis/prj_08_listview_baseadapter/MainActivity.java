package com.everis.prj_08_listview_baseadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_contatos;
    private Adapter_Contatos adapter_contatos;
    private ArrayList<HMAux> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = MainActivity.this;
        //
        lv_contatos = findViewById(R.id.lv_contatos);
        //
        adapter_contatos = new Adapter_Contatos(
                context,
                R.layout.celula,
                gerarDados(100)
        );
        //
        lv_contatos.setAdapter(adapter_contatos);

    }

    private ArrayList<HMAux> gerarDados(int quantidade) {
        ArrayList<HMAux> contatos = new ArrayList<>();
        //
        for (int i = 1; i <= quantidade; i++) {
            HMAux item = new HMAux();
            item.put(HMAux.ID, String.valueOf(i));
            item.put(HMAux.NOME, "Nome - " + String.valueOf(i));
            item.put(HMAux.TELEFONE, "Telefone - " + String.valueOf(i));
            //
            contatos.add(item);
        }
        //
        return contatos;

    }

    private void inicializarAcao() {

        lv_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter_contatos.setItemSelecionado(id);
            }
        });

    }
}
