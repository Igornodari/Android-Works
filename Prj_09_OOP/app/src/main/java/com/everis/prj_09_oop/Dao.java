package com.everis.prj_09_oop;

import java.util.ArrayList;

public interface Dao {

    void inserir(Carro carro);

    void atualizacao(Carro carro);

    void apagar(long idcarro);

    ArrayList<Carro> obterLista();

}
