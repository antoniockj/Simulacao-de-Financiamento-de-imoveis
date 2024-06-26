package modelo;

import util.AcrescimoMaiorDoQueJurosException;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private double areaConstruida;
    private double areaTotal;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTotal) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTotal = areaTotal;
    }

    private void validarJuros(double valorAcrescimo, double juros) throws AcrescimoMaiorDoQueJurosException {
        if (juros < valorAcrescimo) {
            throw new  AcrescimoMaiorDoQueJurosException("Valor do acrescimo modificado para o valor minimo... ");
        }
    }

    public double calcularPagamentoMensal(){
        double acrescimo = 80;
        double juros = ((super.calcularPagamentoMensal() * getPrazoFinanciamento() * 12) - getValorImovel())/getPrazoFinanciamento()*12;
        try {
            validarJuros(acrescimo, juros);
        } catch (AcrescimoMaiorDoQueJurosException e) {
            acrescimo = juros * 0.2;
        }
        return super.calcularPagamentoMensal() + acrescimo;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imovel: ").append(this.getValorImovel()).append("\n");
        sb.append("Taxa de juros anual: ").append(this.getTaxaJurosAnual()).append("\n");
        sb.append("Prazo do financiamento: ").append(this.getPrazoFinanciamento()).append("\n");
        sb.append("Area construida: ").append(this.areaConstruida).append("\n");
        sb.append("Area total: ").append(this.areaTotal).append("\n");
        sb.append("______________");
        return sb.toString();
    }
}
