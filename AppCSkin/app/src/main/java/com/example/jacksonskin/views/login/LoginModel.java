package com.example.jacksonskin.views.login;

import android.content.Context;

import com.example.jacksonskin.Data.ADM;
import com.example.jacksonskin.Data.Usuario;
import com.example.jacksonskin.Utils.LoginValidate;
import com.example.jacksonskin.dao.AdmDao;
import com.example.jacksonskin.dao.UsuarioDao;

import java.util.List;

class LoginModel {
    private LoginValidate loginValidate = new LoginValidate();

    Object checkLogin(String login, String pass, Context context, Usuario usuario, ADM adm) {

        if (loginValidate.checkUserField(login) || loginValidate.checkUserField(pass)) {
            loginValidate.showToast(context, "Erro:User or Pass Empty Field");
            return null;

        } else if (!loginValidate.isValid(login) && !loginValidate.checkPassword(pass)) {
            loginValidate.showToast(context, "Erro: User Formate Error or Password Formate Error ");
            return null;

        } else if (usuario != null) {

            return usuario;
        } else {
            return adm;
        }
    }

    ADM VerificaAdm(String login, String pass, Context context) {
        AdmDao adm = new AdmDao(context);
        List<ADM> admList = adm.buscaUser();
        ADM adm1 = null;

        for (ADM newUser : admList) {
            if (newUser.getEmail().equals(login) &&
                    newUser.getPass().equals(pass) &&
                    newUser.getTipo().equals("ADMINISTRADOR")) {
                {
                    adm1 = newUser;
                }
            }
        }
        if (adm1 == null) {
            loginValidate.showToast(context, "usuario não encontrado");
            return null;
        } else {
            return adm1;
        }
    }

    Usuario VerificaUsuario(String login, String pass, Context context) {

        UsuarioDao usuarioDao = new UsuarioDao(context);
        List<Usuario> usuarioList = usuarioDao.buscaUser();
        Usuario usuario = null;

        for (Usuario newUser : usuarioList) {
            if (newUser.getEmail().equals(login) &&
                    newUser.getPass().equals(pass) &&
                    newUser.getTipo().equals("CLIENTE")) {
                usuario = newUser;
            }
        }

        if (usuario == null) {
            loginValidate.showToast(context, "usuario não encontrado");
            return null;
        } else {
            return usuario;
        }

    }


}
