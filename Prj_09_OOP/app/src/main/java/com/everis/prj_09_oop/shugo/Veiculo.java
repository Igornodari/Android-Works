package com.everis.prj_09_oop.shugo;

public class Veiculo {

    private long idveiculo;
    private String nome;
    private String chassi;
    private long cor;

    public Veiculo() {
        this.idveiculo = -1L;
        this.nome = "";
        this.chassi = "";
        this.cor = -1;
    }


    public Veiculo(long idveiculo, String nome, String chassi, long cor) {
        this.idveiculo = idveiculo;
        this.nome = nome;
        this.chassi = chassi;
        this.cor = cor;
    }

    public long getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(long idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public long getCor() {
        return cor;
    }

    public void setCor(long cor) {
        this.cor = cor;
    }

    public String mostrarDescricao(){
        return getNome() + " - " + String.valueOf(getCor());
    }

    @Deprecated
    public String fazerSaudacao(String nome){
        return  fazerSaudacao(nome, -1);
    }

    public String fazerSaudacao(String nome, int idade){
        String resultado = "Seja bem vindo(a) " + nome;

        if (idade > -1){
            resultado += " Anexo";
        } else {
            resultado += "";
        }

        return  resultado;
    }

    protected String herdeiro(String nome){
        return nome +  " original ";
    }
}
