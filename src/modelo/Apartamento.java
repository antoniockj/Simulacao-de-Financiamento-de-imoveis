package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private int vagas;
    private int andar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagas, int andar){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagas = vagas;
        this.andar = andar;
    }

    public double calcularPagamentoMensal(){
        double taxaMensal = (getTaxaJurosAnual()/12)/100;
        int meses = getPrazoFinanciamento()*12;
        return super.calcularPagamentoMensal() * Math.pow(1+taxaMensal,meses) / Math.pow(1+taxaMensal,meses-1);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imovel: ").append(this.getValorImovel()).append("\n");
        sb.append("Taxa de juros anual: ").append(this.getTaxaJurosAnual()).append("\n");
        sb.append("Prazo do financiamento: ").append(this.getPrazoFinanciamento()).append("\n");
        sb.append("Vagas: ").append(this.vagas).append("\n");
        sb.append("Andar: ").append(this.andar).append("\n");
        sb.append("______________");
        return sb.toString();
    }
}