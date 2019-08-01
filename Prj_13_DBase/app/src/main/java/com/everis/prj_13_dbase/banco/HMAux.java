package com.everis.prj_13_dbase.banco;

import com.everis.prj_13_dbase.dao.ContatoDao;

import java.util.HashMap;

public class HMAux extends HashMap<String, String> {

    @Override
    public String toString() {
        return get(ContatoDao.NOME);
    }
}
