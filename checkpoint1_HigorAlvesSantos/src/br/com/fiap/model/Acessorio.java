package br.com.fiap.model;

public class Acessorio {

    private String descricao;
    private double valor;

    public Acessorio() {}

    public Acessorio(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return
                "Descriçao: " + descricao +
                ", Valor: " + String.format("%.2f",valor);
    }
}
