package com.example.jacksonskin.views.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jacksonskin.Data.ADM;
import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.R;
import com.example.jacksonskin.Utils.LoginValidate;
import com.example.jacksonskin.views.FormC.FormCliente;
import com.example.jacksonskin.views.menu.MenuAdm;
import com.example.jacksonskin.views.menu.MenuCliente;

public class loginActivity extends AppCompatActivity {

    private LoginValidate loginValidate;
    private EditText edt_login;
    private EditText edt_pass;
    private TextView tv_nCadastrado;
    private Button login;
    private String user;
    private String pass;
    private LoginModel loginModel;
    private Usuario usuario;
    private ADM adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarVariaveis();
        iniciarAcao();
    }

    private void iniciarVariaveis() {
        edt_login = findViewById(R.id.edt_login_user);
        edt_pass = findViewById(R.id.edt_login_password);
        tv_nCadastrado = findViewById(R.id.tv_nCadastrado);
        login = findViewById(R.id.btn_login);
        loginModel = new LoginModel();
        loginValidate = new LoginValidate();
        usuario = new Usuario();
        adm = new ADM();
    }

    private void iniciarAcao() {

        tv_nCadastrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormCliente.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = String.valueOf(edt_login.getText());
                pass = String.valueOf(edt_pass.getText());


                adm = loginModel.VerificaAdm(user, pass, getApplicationContext());
                usuario = loginModel.VerificaUsuario(user, pass, getApplicationContext());
                loginModel.checkLogin(user, pass, loginActivity.this, usuario, adm);

                Bundle bundle = new Bundle();
                if (usuario != null && usuario.getTipo().equals("CLIENTE")) {
                    loginValidate.showToast(getApplicationContext(), "Login Success !!!");
                    Intent intent = new Intent(getApplicationContext(), MenuCliente.class);
                    bundle.putSerializable("user", usuario);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();

                } else if (adm != null && adm.getTipo().equals("ADMINISTRADOR")) {

                    loginValidate.showToast(getApplicationContext(), "Login Success !!!");
                    Intent intent = new Intent(getApplicationContext(), MenuAdm.class);
                    bundle.putSerializable("ADM", adm);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();

                } else {
                    loginValidate.showToast(getApplicationContext(), "Login Fail");
                }
            }
        });

    }


}
