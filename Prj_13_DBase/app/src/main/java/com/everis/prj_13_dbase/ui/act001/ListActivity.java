package com.everis.prj_13_dbase.ui.act001;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.everis.prj_13_dbase.R;
import com.everis.prj_13_dbase.banco.Constantes;
import com.everis.prj_13_dbase.banco.HMAux;
import com.everis.prj_13_dbase.dao.ContatoDao;
import com.everis.prj_13_dbase.ui.act002.FormActivity;

public class ListActivity extends AppCompatActivity {

    private Context context;
    private ContatoDao contatoDao;

    private ListView lv_contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = ListActivity.this;
        //
        contatoDao = new ContatoDao(context);
        //
        lv_contatos = findViewById(R.id.list_lv_contatos);
        //
        lv_contatos.setAdapter(
                new ArrayAdapter<HMAux>(
                        context,
                        android.R.layout.simple_list_item_1,
                        contatoDao.obterListaContatos()
                )
        );
    }

    private void chamarFormulario(long idcontato){
        Intent mIntent = new Intent(context, FormActivity.class);
        mIntent.putExtra(Constantes.ID_CONTATO, idcontato);
        //
        startActivity(mIntent);
        //
        finish(); // finish não é return
        //
        Toast.makeText(context, "É nóis véio!!!", Toast.LENGTH_SHORT).show();
    }

    private void inicializarAcao() {
        lv_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux item = (HMAux) parent.getItemAtPosition(position);

                chamarFormulario(
                        Long.parseLong(
                        item.get(ContatoDao.IDCONTATO))
                );
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_novo_contato) {

            chamarFormulario(-1L);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
