package com.example.jacksonskin.model;

import android.content.Context;

import com.example.jacksonskin.data.Admin;
import com.example.jacksonskin.data.User;
import com.example.jacksonskin.utils.SignInValidate;
import com.example.jacksonskin.dao.AdminDao;
import com.example.jacksonskin.dao.UserDao;

import java.util.List;

public class SignInModel {
    private SignInValidate signInValidate = new SignInValidate();

    public User verificaUsuario(String login, String pass, Context context) {

        UserDao userDao = new UserDao(context);
        List<User> userList = userDao.buscaUser();
        User user = null;

        for (User newUser : userList) {
            if (newUser.getEmail().equals(login) &&
                    newUser.getPass().equals(pass) &&
                    newUser.getType().equals("CLIENTE")) {
                user = newUser;
            }
        }

        if (user == null) {
            signInValidate.showToast(context, "user não encontrado");
            return null;
        } else {
            return user;
        }

    }


}
