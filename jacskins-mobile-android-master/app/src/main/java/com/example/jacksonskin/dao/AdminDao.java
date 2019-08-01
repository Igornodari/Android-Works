package com.example.jacksonskin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.jacksonskin.data.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminDao extends SQLiteOpenHelper {


    public AdminDao(Context context) {
        super(context, "Admin", null, 1);
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

    public void insere(Admin admin) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(admin);
        db.insert("Admin", null, dados);
    }

    public List<Admin> buscaUser() {
        String sql = "SELECT*FROM ADM";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Admin> adminList = new ArrayList<Admin>();

        while (c.moveToNext()) {
            Admin admin = new Admin();
            admin.setId((long) c.getInt(c.getColumnIndex("id")));
            admin.setNome(c.getString(c.getColumnIndex("nome")));
            admin.setEmail(c.getString(c.getColumnIndex("email")));
            admin.setPass(c.getString(c.getColumnIndex("pass")));
            admin.setSexo(c.getString(c.getColumnIndex("sexo")));
            admin.setNota(c.getDouble(c.getColumnIndex("nota")));
            admin.setRg(c.getString(c.getColumnIndex("rg")));
            admin.setCpf(c.getString(c.getColumnIndex("cpf")));
            admin.setCep(c.getString(c.getColumnIndex("cep")));
            adminList.add(admin);
        }
        return adminList;
    }

    @NonNull
    private ContentValues getContentValues(Admin admin) {
        ContentValues dados = new ContentValues();
        dados.put("nome", admin.getNome());
        dados.put("email", admin.getEmail());
        dados.put("pass", admin.getPass());
        dados.put("sexo", admin.getSexo());
        dados.put("nota", admin.getNota());
        dados.put("rg", admin.getRg());
        dados.put("cpf", admin.getCpf());
        dados.put("cep", admin.getCep());

        return dados;
    }

    public void deleta(Admin admin) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {admin.getTipo()};
        db.delete("Admin", "admin = ?", params);
    }

    public void altera(Admin adm) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(adm);
        String[] params = {adm.getTipo()};
        db.update("Admin", dados, "adm = ?", params);
    }

}
