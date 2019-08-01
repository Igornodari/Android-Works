package com.everis.prj_15_login_mvp.ui.act_login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.everis.prj_15_login_mvp.R;

public class LoginActivity extends AppCompatActivity
        implements LoginActivityContract.I_View {

    private Context context;

    private EditText et_name;
    private EditText et_password;

    private Button btn_cancel;
    private Button btn_login;

    private LoginActivityContract.I_Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        context = LoginActivity.this;
        //
        et_name = findViewById(R.id.login_et_nome);
        et_password = findViewById(R.id.login_et_senha);
        //
        btn_cancel = findViewById(R.id.login_btn_cancelar);
        btn_login = findViewById(R.id.login_btn_login);
        //
        mPresenter = new LoginActivityPresenter(this);
    }

    private void inicializarAcao() {
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.processCleanForm();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.processLogin(
                        et_name.getText().toString(),
                        et_password.getText().toString()
                );
            }
        });
    }

    @Override
    public void execNav() {
        execShowMessage(R.string.nav_implements);
    }

    @Override
    public void execClearForm() {
        et_name.setText("");
        et_password.setText("");
        //
        et_name.requestFocus();
    }

    @Override
    public void execOnBackPressed() {
        finish();
    }

    @Override
    public void execShowMessage(int resource) {
        Toast.makeText(context, resource, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        mPresenter.processOnBackPressed();
    }
}
