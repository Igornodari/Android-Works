package com.everis.prj_15_login_mvp.ui.act_login;

public interface LoginActivityContract {

    interface I_View {
        void execNav();
        void execClearForm();
        void execOnBackPressed();
        void execShowMessage(int resource);

    }

    interface I_Presenter {

        void processLogin(String name, String password);
        void processCleanForm();
        void processOnBackPressed();

    }
}
