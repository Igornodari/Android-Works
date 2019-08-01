package com.example.appatmconsultoria.Menu.ACT;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.appatmconsultoria.R;

public class servicosACT extends AppCompatActivity {

    private TextView ConsutoriaId;
    private TextView processosID;
    private TextView ACProjetos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos_act);

        getSupportActionBar().setDisplayShowHomeEnabled(true);//getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ConsutoriaId=findViewById(R.id.consultoriaID);
        ConsutoriaId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(servicosACT.this,ConsultingACT.class));
            }
        });
        processosID=findViewById(R.id.processosID);
        processosID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( servicosACT.this,ProcessosACT.class));
            }
        });

    }
    public boolean onOpitionsItensSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {

            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }
    }

