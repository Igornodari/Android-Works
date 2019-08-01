package com.everis.prj_16_login_mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {


    private MutableLiveData<String> mensagem = new MutableLiveData<>();

    public MutableLiveData<String> getMensagem() {
        return mensagem;
    }

    public void checkLogin(String nome, String senha){
        if (nome.trim().isEmpty()){
            mensagem.setValue("Erro: Nome é Obrigatório!!!");
            //
            return;
        }
        //
        if (senha.trim().isEmpty()){
            mensagem.setValue("Erro: Senha é Obrigatória!!!");
            //
            return;
        }
        //
        if ( !nome.equalsIgnoreCase("Hugo") || !senha.equals("T123")){
            mensagem.setValue("Erro: Credenciais Invalidas!!!");
            //
            return;
        } else {
            mensagem.setValue("");
        }
    }
}
