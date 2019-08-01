package com.example.appatmconsultoria.Menu.ACT;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appatmconsultoria.R;


public class clientesACT extends AppCompatActivity {

    private ListView lista;
    private String[]listaClientes={"Vivo","Ambev","Telefonica","Itaú","Santander","Mafre","Claro","Pirelli","BBVA","Ipiranga","Sírio Libanês","Porto Seguro","Pão de Açucar","Sul América","Unilever","Bradesco"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

       getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista=(ListView)findViewById(R.id.listaID);

        ArrayAdapter<String>adaptador=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,listaClientes);

        lista.setAdapter(adaptador);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

          int id=item.getItemId();
        if(id==android.R.id.home){
          this.finish();
}
        return super.onOptionsItemSelected(item);
    }
}
