package main;

import modelo.Financiamento;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List <Financiamento> listaDeFinanciamentos = new ArrayList<>();

        interfaceUsuario.criarFinanciamento(listaDeFinanciamentos);

        InterfaceUsuario.escrever(listaDeFinanciamentos);;
        InterfaceUsuario.ler();
        InterfaceUsuario.escreverObjeto(listaDeFinanciamentos);
        InterfaceUsuario.lerObjeto();
    }
}
