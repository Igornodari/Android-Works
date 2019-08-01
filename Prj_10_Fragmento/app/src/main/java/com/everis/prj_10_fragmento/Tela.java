package com.everis.prj_10_fragmento;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Tela extends AppCompatActivity {

    private Context context;

    private F01 mF01;

    private FragmentManager fm;

    private TextView tv_on;

    private String disponivel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = Tela.this;

        fm = getSupportFragmentManager();

        mF01 = (F01) fm.findFragmentById(R.id.f01_frag);

        tv_on = findViewById(R.id.tv_on);

        recuperarParametros();
    }

    private void recuperarParametros() {
        disponivel = getIntent().getStringExtra(Constantes.PARAMETRO);

        tv_on.setText(disponivel);
    }

    private void inicializarAcao() {
        mF01.setOnMudarTextoListener(new F01.Abacaxi() {
            @Override
            public void mudarTexto(String texto) {
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent mIntent = new Intent(context, MainActivity.class);
        startActivity(mIntent);
        //
        //super.onBackPressed();
        finish();
    }
}
