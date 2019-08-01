package com.everis.prj_15_login_mvp.ui.act_login;

import com.everis.prj_15_login_mvp.R;

public class LoginActivityPresenter
        implements LoginActivityContract.I_Presenter {

    private LoginActivityContract.I_View mView;

    public LoginActivityPresenter(LoginActivityContract.I_View mView) {
        this.mView = mView;
    }

    @Override
    public void processLogin(String name, String password) {
        if (name.trim().isEmpty()) {
            mView.execShowMessage(R.string.error_name);
            //
            return;
        }
        //
        if (password.trim().isEmpty()) {
            mView.execShowMessage(R.string.error_password);
            //
            return;
        }
        //
        if (!name.trim().equalsIgnoreCase("Hugo") ||
                !password.trim().equals("T123")) {
            mView.execShowMessage(R.string.error_credential);
            //
            return;
        }
        //
        mView.execNav();
    }

    @Override
    public void processCleanForm() {
        // implementar caso necessario
        mView.execClearForm();
    }

    @Override
    public void processOnBackPressed() {
        // implementar algo especifico
        mView.execOnBackPressed();
    }
}
