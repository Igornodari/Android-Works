package com.example.jacksonskin.views.crud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.R;
import com.example.jacksonskin.dao.UsuarioDao;
import com.example.jacksonskin.views.FormC.FormCliente;

import java.util.ArrayList;
import java.util.List;

public class ClientesActivity extends Activity {
    private ListView listaClientes;

    ListaClientesAdapter adapter;
    private List<Usuario> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        listaClientes = findViewById(R.id.lista_clientes);

        listaClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuario usuario = (Usuario) listaClientes.getItemAtPosition(position);
                Intent intent = new Intent(ClientesActivity.this, FormCliente.class);
                startActivity(intent.putExtra("Usuario", usuario));
            }
        });

        Button botao = findViewById(R.id.bt_add_aluno);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(ClientesActivity.this, FormCliente.class);
                startActivity(intents);
            }
        });
        registerForContextMenu(listaClientes);
    }


    private void carregaLista() {
        UsuarioDao userdao = new UsuarioDao(this);
        List<Usuario> usuarios = userdao.buscaUser();
        userdao.close();
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usuarios);
        listaClientes.setAdapter(adapter);
    }

    public void setaRecyclerView() {

        //Aqui é instanciado o Recyclerview
        RecyclerView mRecycler = findViewById(R.id.rv_recycler);
        RecyclerView.LayoutManager mLayoutMenager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutMenager);
        adapter = new ListaClientesAdapter(this, itemList);
        mRecycler.setAdapter(adapter);
        mLayoutMenager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(mLayoutMenager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setaRecyclerView();
        carregaLista();
    }

}
