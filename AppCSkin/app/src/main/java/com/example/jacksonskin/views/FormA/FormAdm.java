package com.example.jacksonskin.views.FormA;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.jacksonskin.Data.ADM;
import com.example.jacksonskin.R;
import com.example.jacksonskin.Utils.LoginValidate;
import com.example.jacksonskin.dao.AdmDao;

public class FormAdm extends Activity {

    FormularioAdmHelper helper;
    LoginValidate loginValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_adm);

        iniciarVariaveis();
        iniciarAcao();

    }


    public void iniciarAcao() {
        Intent intent = getIntent();
        ADM adm = (ADM) intent.getSerializableExtra("ADM");
        if (adm != null) {
            helper.preencheForm(adm);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                ADM adm = helper.pegaUser();
                AdmDao dao = new AdmDao(this);

                if (adm.getId() != null) {
                    dao.altera(adm);
                } else if (adm.getTipo().equals("ADMINISTRADOR")) {
                    dao.insere(adm);
                    Toast.makeText(FormAdm.this, "User " + adm.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                } else {
                    loginValidate.showToast(this, "Usuario Não é adm");
                }
                dao.close();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void iniciarVariaveis() {

        helper = new FormularioAdmHelper(this);
        loginValidate = new LoginValidate();
    }
}
