package com.example.jacksonskin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.jacksonskin.Data.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends SQLiteOpenHelper {

    public UsuarioDao(Context context) {
        super(context,"User", null,1);
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

        public void insere(Usuario user) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues dados = getContentValues(user);
            db.insert("User", null, dados);

        }
        public List<Usuario> buscaUser() {
            String sql = "Select*from User;" ;
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery(sql, null);
            List<Usuario> usuarios = new ArrayList<Usuario>();

            while (c.moveToNext()) {
                Usuario usuario = new Usuario();
                usuario.setId(c.getLong(c.getColumnIndex("id")));
                usuario.setNome(c.getString(c.getColumnIndex("nome")));
                usuario.setEmail(c.getString(c.getColumnIndex("email")));
                usuario.setPass(c.getString(c.getColumnIndex("pass")));
                usuario.setSexo(c.getString(c.getColumnIndex("sexo")));
                usuario.setNota( c.getFloat(c.getColumnIndex("nota")));
                usuarios.add(usuario);
            }
            return usuarios;
        }
        @NonNull
     ContentValues getContentValues(Usuario usuario) {
            ContentValues dados = new ContentValues();
            dados.put("nome" ,  usuario.getNome());
            dados.put("email",  usuario.getEmail());
            dados.put("pass" ,  usuario.getPass());
            dados.put("sexo" ,  usuario.getSexo());
            dados.put("nota" ,  usuario.getNota());
            return dados;
        }

        public void deleta(Usuario usuario) {
            SQLiteDatabase db = getWritableDatabase();
            String[] params = {usuario.getId().toString()};
            db.delete("User", "id = ?", params);
        }

        public void altera(Usuario usuario) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues dados = getContentValues(usuario);
            String[] params ={usuario.getId().toString()};
            db.update("User", dados, "id = ?", params);
        }
    }

