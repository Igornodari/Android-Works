package com.everis.prj_13_dbase.ui.act002;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.everis.prj_13_dbase.R;
import com.everis.prj_13_dbase.banco.Constantes;
import com.everis.prj_13_dbase.dao.ContatoDao;
import com.everis.prj_13_dbase.model.Contato;
import com.everis.prj_13_dbase.ui.act001.ListActivity;
import com.everis.prj_13_dbase.util.Toolbox;

public class FormActivity extends AppCompatActivity {

    private Context context;
    private ContatoDao contatoDao;

    private EditText et_codigo;
    private EditText et_nome;
    private EditText et_telefone;
    private EditText et_idade;

    private Button btn_excluir;
    private Button btn_salvar;

    private long idAtual = 0L;

    private String mensagem = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_form);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = FormActivity.this;
        //
        contatoDao = new ContatoDao(context);
        //
        recuperarParametros();
        //
        et_codigo = findViewById(R.id.form_et_codigo);
        et_nome = findViewById(R.id.form_et_nome);
        et_telefone = findViewById(R.id.form_et_telefone);
        et_idade = findViewById(R.id.form_et_idade);
        //
        btn_excluir = findViewById(R.id.form_btn_excluir);
        btn_salvar = findViewById(R.id.form_btn_salvar);
        //
        if (idAtual == -1){
            btn_excluir.setEnabled(false);
        } else {
            Contato cAux = contatoDao.obterContatoByID(idAtual);
            //
            et_codigo.setText(String.valueOf(cAux.getIdcontato()));
            et_nome.setText(cAux.getNome());
            et_telefone.setText(cAux.getTelefone());
            et_idade.setText(String.valueOf(cAux.getIdade()));
        }

    }

    private void recuperarParametros() {
        idAtual = getIntent().getLongExtra(Constantes.ID_CONTATO, 0L);
    }

    private void inicializarAcao() {
        btn_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatoDao.apagarContato(idAtual);
                //
                chamarListActivity();
            }
        });

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validacao()){
                    salvar();
                } else {
                    Toolbox.exibirMensagem(context, mensagem);
                }
            }
        });

    }

    private boolean validacao() {
        String nome = et_nome.getText().toString().trim();
        String telefone = et_telefone.getText().toString().trim();
        int idade = Toolbox.converteInteiros(et_idade.getText().toString());

        if (nome.isEmpty()){
            mensagem = "Erro: Nome é Obrigatório.!!!";

            return false;
        }
        //
        if (telefone.isEmpty()){
            mensagem = "Erro: Telefone é Obrigatório.!!!";

            return false;
        }
        //
        if (idade == -1){
            mensagem = "Erro: Idade Invalida!!!";

            return false;
        }

        return true;
    }

    private void salvar() {
        Contato cAux = new Contato();
        cAux.setNome(et_nome.getText().toString().trim());
        cAux.setTelefone(et_telefone.getText().toString().trim());
        cAux.setIdade(
                Toolbox.converteInteiros(
                        et_idade.getText().toString())
        );
        //
        if(idAtual != -1){
            cAux.setIdcontato(idAtual);
            //
            contatoDao.alterarContato(cAux);
        } else {
            idAtual = contatoDao.proximoId();
            cAux.setIdcontato(idAtual);
            //
            contatoDao.inserirContato(cAux);
            //
            et_codigo.setText(String.valueOf(cAux.getIdcontato()));
            btn_excluir.setEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        caixaDeAlerta("Sair do Formulario", "Deseja realmente sair do formulario?");
    }

    private void chamarListActivity() {
        Intent mIntent = new Intent(context, ListActivity.class);
        startActivity(mIntent);
        //
        finish();
    }

    private void caixaDeAlerta(String titulo, String mensagem){
        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setCancelable(false);
        alerta.setNegativeButton("Não", null);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chamarListActivity();
            }
        });
        //
        alerta.show();
    }
}
