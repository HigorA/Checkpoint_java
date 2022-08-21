package br.com.fiap.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Veiculo {

    private Date anoDeFabricacao;
    private String modelo;
    private double valor;
    private String montadora;

    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

    private List<Acessorio> acessorios = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(Date anoDeFabricacao, String modelo, double valor, String montadora) {
        this.anoDeFabricacao = anoDeFabricacao;
        this.modelo = modelo;
        this.valor = valor;
        this.montadora = montadora;
    }

    public Date getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(Date anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void addAcessorios(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }

    @Override
    public String toString() {
        return
                "Ano De Fabricacao: " + formatter.format(anoDeFabricacao) +
                ", Modelo: '" + modelo + '\'' +
                ", Valor: " + String.format("%.2f",valor) +
                ", Montadora: '" + montadora + '\'' +
                ", Acessorios: " + acessorios + "\n"
                ;
    }
}
