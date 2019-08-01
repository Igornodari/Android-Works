package com.example.appatmconsultoria.Login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


public class VIEWMODEL extends ViewModel {

    private MutableLiveData<String>mensagem=new MutableLiveData<>();

    public MutableLiveData<String>getMensagem(){
        return mensagem;
    }


    public Boolean checkLogin(String nome, String senha) {
        if (nome.trim().isEmpty()) {
            mensagem.setValue("Erro: Nome é Obrigatório!!!");

            return false;
        }
        //
        if (senha.trim().isEmpty()) {
            mensagem.setValue("Erro: Senha é Obrigatória!!!");
            //
            return false;
        }
        //
        if (!nome.equalsIgnoreCase("Igor") || !senha.equals("T123")) {
            mensagem.setValue("Erro: Credenciais Invalidas!!!");
            //
            return false;

        } else  {
            return true;
        }

    }
}
