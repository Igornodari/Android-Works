package com.example.jacksonskin.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.jacksonskin.Data.Produto;
import com.example.jacksonskin.views.FormC.FormCliente;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends SQLiteOpenHelper {

    public ProdutoDao(FormCliente context) {
        super(context, "Produtos", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Produtos(id INTEGER PRIMARY KEY,title TEXT NOT NULL,quantidade int,descricao TEXT,nota REAL,preco Double,image BLOB);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Produtos";

        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(produto);
        db.insert("Produtos", null, dados);
    }

    public List<Produto> buscaProduto() {

        String sql = "SELECT*FROM Produtos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Produto> produtos = new ArrayList<Produto>();

        while (c.moveToNext()) {
            Produto produto = new Produto();
            produto.setId(c.getLong(c.getColumnIndex("id")));
            produto.setTitle(c.getString(c.getColumnIndex("title")));
            produto.setQuantidade(c.getInt(c.getColumnIndex("quantidade")));
            produto.setDesc(c.getString(c.getColumnIndex("desc")));
            produto.setNota(c.getDouble(c.getColumnIndex("nota")));
            produto.setPreco(c.getDouble(c.getColumnIndex("preco")));
            produto.setImage(c.getInt(c.getColumnIndex("image")));
            produtos.add(produto);

        }
        c.close();

        return produtos;
    }

    @NonNull
    private ContentValues getContentValues(Produto produto) {
        ContentValues dados = new ContentValues();
        dados.put("id", produto.getId());
        dados.put("title", produto.getTitle());
        dados.put("quantidade", produto.getQuantidade());
        dados.put("desc", produto.getDesc());
        dados.put("nota", produto.getNota());
        dados.put("preco", produto.getPreco());
        dados.put("image", produto.getImage());
        return dados;
    }

    public void deleta(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {String.valueOf(produto.getId())};
        db.delete("Produtos", "id = ?", params);
    }

    public void altera(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(produto);
        String[] params = {String.valueOf(produto.getId())};
        db.update("Produtos", dados, "id = ?", params);
    }
}
