package com.everis.mylibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

public class ToolBox {


    public static void exibirMensagem(
            Context context,
            String mensagem){

        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();

    }

    public static void exibirMensagem(
            Context context,
            String titulo,
            String mensagem){

        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setPositiveButton("Ok", null);
        //
        alerta.show();
    }

    public static void exibirMensagem(
            Context context,
            String titulo,
            String mensagem,
            Dialog.OnClickListener listener){

        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setPositiveButton("Ok", listener);
        //
        alerta.show();
    }

}
