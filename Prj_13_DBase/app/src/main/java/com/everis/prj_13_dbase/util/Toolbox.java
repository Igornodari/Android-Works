package com.everis.prj_13_dbase.util;

import android.content.Context;
import android.widget.Toast;

public class Toolbox {

    public static void exibirMensagem(Context context, String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

    public static int converteInteiros(String texto){
        try{
            return Integer.parseInt(texto);
        } catch (Exception e){
            return -1;
        }
    }
}
