package com.example.jacksonskin.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.jacksonskin.data.Product;
import com.example.jacksonskin.activity.SignUpActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductDao extends SQLiteOpenHelper {

    public ProductDao(SignUpActivity context) {
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

    public void insere(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(product);
        db.insert("Produtos", null, dados);
    }

    public List<Product> buscaProduto() {

        String sql = "SELECT*FROM Produtos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Product> products = new ArrayList<Product>();

        while (c.moveToNext()) {
            Product product = new Product();
            product.setId(c.getLong(c.getColumnIndex("id")));
            product.setTitle(c.getString(c.getColumnIndex("title")));
            product.setAmount(c.getInt(c.getColumnIndex("quantidade")));
            product.setDesc(c.getString(c.getColumnIndex("desc")));
            product.setRating(c.getDouble(c.getColumnIndex("nota")));
            product.setPrice(c.getDouble(c.getColumnIndex("preco")));
            product.setImage(c.getInt(c.getColumnIndex("image")));
            products.add(product);

        }
        c.close();

        return products;
    }

    @NonNull
    private ContentValues getContentValues(Product product) {
        ContentValues dados = new ContentValues();
        dados.put("id", product.getId());
        dados.put("title", product.getTitle());
        dados.put("quantidade", product.getAmount());
        dados.put("desc", product.getDesc());
        dados.put("nota", product.getRating());
        dados.put("preco", product.getPrice());
        dados.put("image", product.getImage());
        return dados;
    }

    public void deleta(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {String.valueOf(product.getId())};
        db.delete("Produtos", "id = ?", params);
    }

    public void altera(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(product);
        String[] params = {String.valueOf(product.getId())};
        db.update("Produtos", dados, "id = ?", params);
    }
}
