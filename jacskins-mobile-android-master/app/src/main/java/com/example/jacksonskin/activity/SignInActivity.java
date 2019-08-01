package com.example.jacksonskin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.jacksonskin.base.BaseActivity;
import com.example.jacksonskin.data.User;
import com.example.jacksonskin.R;
import com.example.jacksonskin.model.SignInModel;
import com.example.jacksonskin.preferences.AppPreferencesHelper;
import com.example.jacksonskin.utils.AppConstants;
import com.example.jacksonskin.utils.SignInValidate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends BaseActivity {

    private SignInValidate signInValidate;

    @BindView(R.id.edt_login_user)
    EditText edt_login;

    @BindView(R.id.edt_login_password)
    EditText edt_pass;

    private SignInModel signInModel;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
        setUp();
    }


    @OnClick(R.id.tv_nCadastrado)
    void openSignUp() {
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_login)
    void signIni() {
        String user = String.valueOf(edt_login.getText());
        String pass = String.valueOf(edt_pass.getText());


        if (!SignInValidate.EmailValidator.isValidEmail(user)) {
            showMessage(getString(R.string.error_invalid_email));
            return;
        }

        if (user.isEmpty()) {
            showMessage(getString(R.string.error_empty_email));
            return;
        } else if (pass.isEmpty()) {
            showMessage(getString(R.string.error_empty_password));
            return;
        }

        this.user = signInModel.verificaUsuario(user, pass, getApplicationContext());

        Bundle bundle = new Bundle();
        if (this.user != null && this.user.getType().equals("CLIENTE")) {
            appPreferencesHelper.setUserLogged(true);
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            bundle.putSerializable("user", this.user);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();

        } else {
            signInValidate.showToast(getApplicationContext(), getString(R.string.error_user_login));
        }
    }

    @Override
    protected void setUp() {
        appPreferencesHelper = new AppPreferencesHelper(this, AppConstants.PREF_NAME);

        if (appPreferencesHelper.isUserLogged()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
        signInModel = new SignInModel();
        signInValidate = new SignInValidate();
        user = new User();
    }
}
