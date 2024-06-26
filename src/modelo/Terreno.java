package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private boolean permitidoComercio;

    public Terreno (double valorImovel, int prazoFinanciamento, double taxaJurosAnual, boolean permitidoComercio){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.permitidoComercio = permitidoComercio;
    }

    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() * 1.02;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imovel: ").append(this.getValorImovel()).append("\n");
        sb.append("Taxa de juros anual: ").append(this.getTaxaJurosAnual()).append("\n");
        sb.append("Prazo do financiamento: ").append(this.getPrazoFinanciamento()).append("\n");
        if (this.permitidoComercio == true) {
            sb.append("Permitido comercio! ").append("\n");
        }else {
            sb.append("Nao permitido comercio! ").append(this.getPrazoFinanciamento()).append("\n");
        }
        sb.append("______________");
        return sb.toString();
    }
}