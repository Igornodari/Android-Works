package com.example.appatmconsultoria.Login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appatmconsultoria.Dash.AppEveris;
import com.example.appatmconsultoria.R;

public class MainACT extends AppCompatActivity {
    private Context context;
    private EditText et_nome;
    private EditText et_senha;

    private Button btn_login;
    private Button btn_cancel;

    private VIEWMODEL viewmodel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Login);

        inicializarVariaveis();
        inicializarAcao();
    }
    private void inicializarVariaveis() {
        context = MainACT.this;
        //
        et_nome = findViewById(R.id.login_et_nome);
        et_senha = findViewById(R.id.login_et_senha);
        //
        btn_cancel = findViewById(R.id.login_btn_cancelar);
        btn_login = findViewById(R.id.login_btn_login);

        viewmodel = ViewModelProviders
                .of(this)
                .get(VIEWMODEL.class);

        viewmodel.getMensagem().observe(
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
        btn_cancel.setOnClickListener(v -> limparFormulario());
        btn_login.setOnClickListener(v -> {

            if(viewmodel.checkLogin(
                    et_nome.getText().toString(),
                    et_senha.getText().toString()

            )){
                startActivity(new Intent(MainACT.this, AppEveris.class));
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
