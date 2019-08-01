package com.example.jacksonskin.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.jacksonskin.base.BaseActivity;
import com.example.jacksonskin.data.User;
import com.example.jacksonskin.R;
import com.example.jacksonskin.utils.SignInValidate;
import com.example.jacksonskin.dao.UserDao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    SignInValidate signInValidate = new SignInValidate();
    private User user;

    @BindView(R.id.input_name)
    EditText etName;
    @BindView(R.id.input_email)
    EditText etEmail;
    @BindView(R.id.input_password)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        setUp();
    }

    @OnClick(R.id.btn_signup)
    public void onClickCreateAccount() {
        String userLogin = etEmail.getText().toString();
        String userName = etName.getText().toString();
        String userPassword = etPassword.getText().toString();

        if (!SignInValidate.EmailValidator.isValidEmail(userLogin)) {
            showMessage(getString(R.string.error_invalid_email));
            return;
        } else if (userName.isEmpty()) {
            showMessage(getString(R.string.error_empty_user_name));
            return;
        } else if (userLogin.isEmpty()) {
            showMessage(getString(R.string.error_empty_email));
            return;
        } else if (userPassword.isEmpty()) {
            showMessage(getString(R.string.error_empty_password));
            return;
        }
        User user = getUser();
        UserDao dao = new UserDao(this);

        if (user.getId() != null) {
            dao.altera(user);
        } else if (user.getType().equals("CLIENTE") && !user.getName().equals("igor")) {
            dao.insere(user);
        } else {
            signInValidate.showToast(getApplicationContext(), "User " + user.getName() + " Restrito para Admin!");
        }
        showMessage(getString(R.string.account_created_successfully));
        dao.close();
        finish();
    }

    @Override
    protected void setUp() {
        user = new User();
    }


    @OnClick(R.id.link_login)
    public void openLogin() {
        finish();
    }

    private User getUser() {
        user.setName(etName.getText().toString());
        user.setEmail(etEmail.getText().toString().toLowerCase().trim());
        user.setSex("");
        user.setPass(etPassword.getText().toString().trim());
        user.setReview((float) 0);
        return user;
    }
}
