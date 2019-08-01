package com.example.jacksonskin.views.FormC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.R;
import com.example.jacksonskin.Utils.LoginValidate;
import com.example.jacksonskin.dao.UsuarioDao;

import java.io.ByteArrayOutputStream;

public class FormCliente extends Activity {

    private FormularioClienteHelper helper;
    LoginValidate loginValidate = new LoginValidate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cliente);

        iniciarVariaveis();
        iniciarAcao();
    }

    public void iniciarAcao() {
        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra("Usuario");
        if (usuario != null) {
            helper.preencheForm(usuario);
        }
        onClick();
    }

    public void iniciarVariaveis() {

        helper = new FormularioClienteHelper(this);

    }

    private void onClick() {
        ImageButton imageButton = findViewById(R.id.bt_foto);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                startActivity(intentFoto);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:

                Usuario usuario = helper.pegaUser();
                UsuarioDao dao = new UsuarioDao(this);

                if (usuario.getId() != null) {
                    dao.altera(usuario);
                } else if (usuario.getTipo().equals("CLIENTE") && !usuario.getNome().equals("igor")) {
                    dao.insere(usuario);
                    loginValidate.showToast(getApplicationContext(), "Cliente " + usuario.getNome() + " salvo!");
                } else {
                    loginValidate.showToast(getApplicationContext(), "Usuario " + usuario.getNome() + " Restrito para ADM!");
                }
                dao.close();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
