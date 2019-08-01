package com.example.jacksonskin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.jacksonskin.Data.ADM;

import java.util.ArrayList;
import java.util.List;

public class AdmDao extends SQLiteOpenHelper {


    public AdmDao(Context context) {
        super(context, "ADM", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE ADM(id INTEGER PRIMARY KEY " + "," +
                "nome TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "pass TEXT not null," +
                "sexo TEXT," +
                "nota REAL," +
                "rg TEXT not null," +
                "cpf TEXT not null," +
                "cep TEXT not null);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS ADM";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(ADM adm) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(adm);
        db.insert("ADM", null, dados);
    }

    public List<ADM> buscaUser() {
        String sql = "SELECT*FROM ADM";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<ADM> admList = new ArrayList<ADM>();

        while (c.moveToNext()) {
            ADM adm = new ADM();
            adm.setId((long) c.getInt(c.getColumnIndex("id")));
            adm.setNome(c.getString(c.getColumnIndex("nome")));
            adm.setEmail(c.getString(c.getColumnIndex("email")));
            adm.setPass(c.getString(c.getColumnIndex("pass")));
            adm.setSexo(c.getString(c.getColumnIndex("sexo")));
            adm.setNota(c.getDouble(c.getColumnIndex("nota")));
            adm.setRg(c.getString(c.getColumnIndex("rg")));
            adm.setCpf(c.getString(c.getColumnIndex("cpf")));
            adm.setCep(c.getString(c.getColumnIndex("cep")));
            admList.add(adm);
        }
        return admList;
    }

    @NonNull
    private ContentValues getContentValues(ADM adm) {
        ContentValues dados = new ContentValues();
        dados.put("nome", adm.getNome());
        dados.put("email", adm.getEmail());
        dados.put("pass", adm.getPass());
        dados.put("sexo", adm.getSexo());
        dados.put("nota", adm.getNota());
        dados.put("rg", adm.getRg());
        dados.put("cpf", adm.getCpf());
        dados.put("cep", adm.getCep());

        return dados;
    }

    public void deleta(ADM adm) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {adm.getTipo()};
        db.delete("ADM", "adm = ?", params);
    }

    public void altera(ADM adm) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(adm);
        String[] params = {adm.getTipo()};
        db.update("ADM", dados, "adm = ?", params);
    }

}
