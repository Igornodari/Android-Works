package com.everis.prj_13_dbase.model;

public class Contato {

    private long idcontato;
    private String nome;
    private String telefone;
    private int idade;

    public Contato() {
        this.idcontato = -1L;
        this.nome = "";
        this.telefone = "";
        this.idade = -1;
    }

    public Contato(long idcontato, String nome, String telefone, int idade) {
        this.idcontato = idcontato;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
    }

    public long getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(long idcontato) {
        this.idcontato = idcontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
