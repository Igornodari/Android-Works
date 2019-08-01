package com.everis.prj_10_fragmento;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private F01 mF01;
    private F02 mF02;

    private FragmentManager fm;

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
        fm = getSupportFragmentManager();
        //
        mF01 = (F01) fm.findFragmentById(R.id.f01_frag);

        mF01.setOnMudarTextoListener(new F01.Abacaxi() {
            @Override
            public void mudarTexto(String texto) {
                //mF02.changeTexto(texto);
                //Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();

                Intent mIntent = new Intent(context, Tela.class);
                mIntent.putExtra(Constantes.PARAMETRO, texto);
                startActivity(mIntent);
                //
                finish();
            }
        });

        mF02 = (F02) fm.findFragmentById(R.id.f02_frag);
    }

    private void inicializarAcao() {

    }

//    public void fazendoM(String texto){
//        mF02.changeTexto(texto);
//    }
}
