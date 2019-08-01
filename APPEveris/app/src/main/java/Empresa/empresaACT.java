package Empresa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.appatmconsultoria.*;
import com.example.appatmconsultoria.Menu.ACT.ConsultingACT;
import com.example.appatmconsultoria.Menu.ACT.OperationACT;
import com.example.appatmconsultoria.Menu.ACT.TecnologyACT;
import com.example.appatmconsultoria.Menu.ACT.TransformationACT;

public class empresaACT extends AppCompatActivity {

    private ListView lista;
    private String[]listaSobre={"Disrupção","Tecnologia","Operação","Transformação","Consulta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresaact);


        lista=(ListView)findViewById(R.id.listaID) ;
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,listaSobre);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"CLICK ON",Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        startActivity(new Intent(empresaACT.this,disrupcaoACT.class));
                    break;
                    case 1:
                        startActivity(new Intent(empresaACT.this,TecnologyACT.class));
                    break;
                    case 2:
                        startActivity(new Intent(empresaACT.this,OperationACT.class));
                    break;
                    case 3:
                        startActivity(new Intent(empresaACT.this,TransformationACT.class));
                    break;
                    case 4:
                        startActivity(new Intent(empresaACT.this,ConsultingACT.class));
                    break;
                }
            }
        });




        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


