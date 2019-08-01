package com.everis.prj_13_dbase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.everis.prj_13_dbase.banco.Dao;
import com.everis.prj_13_dbase.banco.HMAux;
import com.everis.prj_13_dbase.model.Contato;

import java.util.ArrayList;

public class ContatoDao extends Dao {

    public static final String TABELA = "contatos";
    public static final String IDCONTATO = "idcontato";
    public static final String NOME = "nome";
    public static final String TELEFONE = "telefone";
    public static final String IDADE = "idade";

    public ContatoDao(Context context) {
        super(context);
    }

    public void inserirContato(Contato contato) {
        abrirBanco();
        //
        ContentValues cv = new ContentValues();
        //
        cv.put(IDCONTATO, contato.getIdcontato());
        cv.put(NOME, contato.getNome());
        cv.put(TELEFONE, contato.getTelefone());
        cv.put(IDADE, contato.getIdade());
        //
        db.insert(TABELA, null, cv);
        //
        fecharBanco();
    }

    public void alterarContato(Contato contato) {
        abrirBanco();
        //
        ContentValues cv = new ContentValues();
        //
        String filtro = IDCONTATO + " = ? ";
        String[] parametros = {String.valueOf(contato.getIdcontato())};
        //cv.put(IDCONTATO, contato.getIdcontato());
        cv.put(NOME, contato.getNome());
        cv.put(TELEFONE, contato.getTelefone());
        cv.put(IDADE, contato.getIdade());
        //
        db.update(TABELA, cv, filtro, parametros);
        //
        fecharBanco();
    }

    public void apagarContato(long idcontato) {
        abrirBanco();
        //
        String filtro = IDCONTATO + " = ? ";
        String[] parametros = {String.valueOf(idcontato)};
        //
        db.delete(TABELA, filtro, parametros);
        //
        fecharBanco();
    }

    public Contato obterContatoByID(long idcontato) {
        Contato cAux = null;
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            String comando = " select * from contatos where idcontato = ? ";
            String[] parametros = {String.valueOf(idcontato)};
            //
            cursor = db.rawQuery(comando, parametros);
            //
            while (cursor.moveToNext()) {
                cAux = new Contato();
                //
                cAux.setIdcontato(cursor.getLong(cursor.getColumnIndex(IDCONTATO)));
                cAux.setNome(cursor.getString(cursor.getColumnIndex(NOME)));
                cAux.setTelefone(cursor.getString(cursor.getColumnIndex(TELEFONE)));
                cAux.setIdade(cursor.getInt(cursor.getColumnIndex(IDADE)));
            }
            //
            cursor.close();

        } catch (Exception e) {
        }
        //
        fecharBanco();
        //
        return cAux;
    }

    public ArrayList<HMAux> obterListaContatos() {
        ArrayList<HMAux> contatos = new ArrayList<>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            String comando = " select idcontato, nome from contatos order by nome ";
            //
            cursor = db.rawQuery(comando, null);
            //
            while (cursor.moveToNext()) {
                HMAux aux = new HMAux();
                //
                aux.put(
                        IDCONTATO,
                        cursor.getString(cursor.getColumnIndex(IDCONTATO))
                );
                aux.put(
                        NOME,
                        cursor.getString(cursor.getColumnIndex(NOME))
                );


                contatos.add(aux);
            }
            //
            cursor.close();

        } catch (Exception e) {
        }
        //
        fecharBanco();
        //
        return contatos;
    }

    public long proximoId() {
        long proID = -1L;
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            String comando = " select  ifnull(max(idcontato)+1, 1) id from contatos  ";
            //
            cursor = db.rawQuery(comando, null);
            //
            while (cursor.moveToNext()) {
                proID = cursor.getLong(cursor.getColumnIndex("id"));
            }
            //
            cursor.close();

        } catch (Exception e) {
        }
        //
        fecharBanco();
        //
        return proID;
    }
}
