package com.example.jacksonskin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.jacksonskin.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao extends SQLiteOpenHelper {


    public UserDao(Context context) {
        super(context, "User", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User(id INTEGER PRIMARY KEY AUTOINCREMENT ,nome TEXT NOT NULL,email TEXT UNIQUE NOT NULL ,pass TEXT NOT NULL,sexo TEXT,nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS User";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(user);
        db.insert("User", null, dados);

    }

    public List<User> buscaUser() {
        String sql = "Select*from User;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<User> users = new ArrayList<User>();

        while (c.moveToNext()) {
            User user = new User();
            user.setId(c.getLong(c.getColumnIndex("id")));
            user.setName(c.getString(c.getColumnIndex("nome")));
            user.setEmail(c.getString(c.getColumnIndex("email")));
            user.setPass(c.getString(c.getColumnIndex("pass")));
            user.setSex(c.getString(c.getColumnIndex("sexo")));
            user.setReview(c.getFloat(c.getColumnIndex("nota")));
            users.add(user);
        }
        return users;
    }

    @NonNull
    ContentValues getContentValues(User user) {
        ContentValues dados = new ContentValues();
        dados.put("nome", user.getName());
        dados.put("email", user.getEmail());
        dados.put("pass", user.getPass());
        dados.put("sexo", user.getSex());
        dados.put("nota", user.getReview());
        return dados;
    }


    public void deleta(User user) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {user.getId().toString()};
        db.delete("User", "id = ?", params);
    }

    public void altera(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(user);
        String[] params = {user.getId().toString()};
        db.update("User", dados, "id = ?", params);
    }

}

