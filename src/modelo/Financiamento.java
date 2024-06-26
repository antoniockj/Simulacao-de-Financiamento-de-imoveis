package modelo;

import java.io.Serializable;

public abstract class  Financiamento implements Serializable {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public  Financiamento (double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

    public double calcularPagamentoMensal(){
        return (getValorImovel()/( getPrazoFinanciamento()*12)) * (1 + (getTaxaJurosAnual() / 12));
    }

    public double calculaTotalPagamento(){
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }
}