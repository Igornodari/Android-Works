package com.everis.prj_13_dbase.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Dao {

    private Context context;
    protected SQLiteDatabase db;


    public Dao(Context context) {
        this.context = context;
    }

    public void abrirBanco(){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(
                context,
                Constantes.NOME,
                null,
                Constantes.VERSAO
        );

        this.db = sqLiteHelper.getWritableDatabase();
    }

    public void fecharBanco(){
        if (db != null && db.isOpen()){
            db.close();
        }
    }
}
