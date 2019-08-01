package com.everis.prj_16_login_mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_nome;
    private EditText et_senha;

    private Button btn_cancelar;
    private Button btn_login;

    private MainActivityViewModel mainActivityViewModel;

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
        et_nome = findViewById(R.id.login_et_nome);
        et_senha = findViewById(R.id.login_et_senha);
        //
        btn_cancelar = findViewById(R.id.login_btn_cancelar);
        btn_login = findViewById(R.id.login_btn_login);

        mainActivityViewModel = ViewModelProviders
                .of(this)
                .get(MainActivityViewModel.class);

        mainActivityViewModel.getMensagem().observe(
                this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String texto) {
                        if (texto.isEmpty()) {
                            nav();
                        } else {
                            exibirMensagem(texto);
                        }
                    }
                }
        );
    }

    private void nav() {
        Toast.makeText(context, "Navegacao Nao Implementada!!!", Toast.LENGTH_SHORT).show();
    }

    private void exibirMensagem(String texto) {
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
    }

    private void inicializarAcao() {
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparFormulario();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.checkLogin(
                        et_nome.getText().toString(),
                        et_senha.getText().toString()
                );
            }
        });
    }

    private void limparFormulario() {
        et_nome.setText("");
        et_senha.setText("");
        //
        et_nome.requestFocus();
    }
}
