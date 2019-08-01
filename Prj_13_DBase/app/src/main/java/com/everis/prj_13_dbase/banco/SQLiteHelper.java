package com.everis.prj_13_dbase.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{

            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE IF NOT EXISTS [contatos] ( [idcontato] int not null, [nome] text not null default '' collate nocase, [telefone] text not null default '' collate nocase, [idade] int not null, constraint pk_contatos primary key(idcontato) );");
            //
            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }
        }catch (Exception e){
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{

            StringBuilder sb = new StringBuilder();
            sb.append("DROP TABLE IF EXISTS [contatos];");
            //
            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }
        }catch (Exception e){
        }

        onCreate(db);
    }
}
