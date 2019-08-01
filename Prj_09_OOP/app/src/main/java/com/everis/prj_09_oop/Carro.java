package com.everis.prj_09_oop;

import com.everis.prj_09_oop.shugo.Veiculo;

public class Carro extends Veiculo {


    @Override
    public String fazerSaudacao(String nome, int idade) {



        getNome();


        return " Agora é nóis!!!";


    }

    @Override
    public String herdeiro(String nome) {
         return super.herdeiro(nome) + " novo ";
    }
}
