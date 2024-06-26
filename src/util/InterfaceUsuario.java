package util;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class InterfaceUsuario {
    Scanner ler = new Scanner(System.in);
    String msgErro = "Valor inválido, digite um valor válido!\n";

    public double pedirValorImovel() {
        boolean validado = false;
        double valorImovel = 0;
        while (!validado) {
            try {
                System.out.print("Qual o valor do imóvel:\n");
                valorImovel = ler.nextDouble();
                if (valorImovel > 0) {
                    validado = true;
                } else {
                    System.out.printf(msgErro);
                }
            } catch (InputMismatchException e) {
                System.out.printf(msgErro);
                ler.nextDouble();
            }
        }
        return valorImovel;
    }

    public int pedirPrazoDeFinanciamento() {
        boolean validado = false;
        int prazoDeFinanciamento = 0;
        while (!validado) {
            try {
                System.out.print("Qual o prazo do financiamento em anos:\n");
                prazoDeFinanciamento = ler.nextInt();
                if (prazoDeFinanciamento > 0) {
                    validado = true;
                } else {
                    System.out.printf(msgErro);
                }
            } catch (InputMismatchException e) {
                System.out.printf(msgErro);
                ler.nextLine();
            }
        }
        return prazoDeFinanciamento;
    }

    public double pedirTaxasJurosAnual() {
        boolean validado = false;
        double taxasJurosAnual = 0;
        while (!validado) {
            try {
                System.out.print("Qual a taxa de juros anual:\n");
                taxasJurosAnual = ler.nextDouble();
                if (taxasJurosAnual > 0 && taxasJurosAnual <= 30) {
                    validado = true;
                } else {
                    System.out.print(msgErro);
                }
            } catch (Exception e) {
                System.out.print(msgErro);
                ler.next();
            }
        }
        return taxasJurosAnual;
    }

    public String getTipoFinanciamento() {
        String tipoFinanciamento = null;
        System.out.println("O que você quer financiar? ");

        while (!"Casa".equalsIgnoreCase(tipoFinanciamento) && !"Apartamento".equalsIgnoreCase(tipoFinanciamento) && !"Terreno".equalsIgnoreCase(tipoFinanciamento)) {
            tipoFinanciamento = ler.nextLine();
            if (!"Casa".equalsIgnoreCase(tipoFinanciamento) && !"Apartamento".equalsIgnoreCase(tipoFinanciamento) && !"Terreno".equalsIgnoreCase(tipoFinanciamento)) {
                System.out.println("Opção inválida, digite uma das opções válidas: Casa, Apartamento, Terreno.");
            }
        }

        return tipoFinanciamento;
    }

    public void criarFinanciamento(List<Financiamento> listaDeFinanciamentos) {
        int continuar = 1;

        while (continuar == 1) {
            String tipoFinanciamento = getTipoFinanciamento();
            double taxaJuros = pedirTaxasJurosAnual();
            int prazo = pedirPrazoDeFinanciamento();
            double valorImovel = pedirValorImovel();
            Financiamento financiamento = null;

            switch (tipoFinanciamento.toLowerCase()) {
                case "casa":
                    financiamento = new Casa(valorImovel, prazo, taxaJuros, 70, 100);
                    break;
                case "apartamento":
                    financiamento = new Apartamento(valorImovel, prazo, taxaJuros, 1, 3);
                    break;
                case "terreno":
                    financiamento = new Terreno(valorImovel, prazo, taxaJuros, true);
                    break;
                default:
                    System.out.println("Financiamento não existe.");
            }

            if (financiamento != null) {
                listaDeFinanciamentos.add(financiamento);
            }

            System.out.print("Se quiser financiar outro digite 1, senão digite 0: ");
            continuar = ler.nextInt();
            ler.nextLine();
        }

    }

    public static void lerObjeto() {
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream("financiamentos.objetos"));

            Object object = null;
            while ((object = inputStream.readObject()) != null) {
                if (object instanceof Financiamento) {
                    System.out.println(object);
                }
            }
            inputStream.close();
        } catch (EOFException e) {
            System.out.println("fim do arquivo!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

        public static void escreverObjeto(List<Financiamento> listaDeFinanciamentos) {
        ObjectOutputStream outputStream = null;

        try {
                outputStream = new ObjectOutputStream(new FileOutputStream("financiamentos.objetos"));
                outputStream.writeObject(listaDeFinanciamentos);
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void escrever (List < Financiamento > listaFinanciamentos) {
            try (FileWriter escritor = new FileWriter("financiamentos.txt", true)) {
                for (Financiamento financiamento : listaFinanciamentos) {
                    escritor.write(financiamento.toString() + "\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void ler () {
            FileReader leitor = null;
            try {
                leitor = new FileReader("financiamentos.txt");
                int caracter;
                while ((caracter = leitor.read()) != -1) {
                    System.out.print((char) caracter);
                }
                leitor.close();
            } catch (FileNotFoundException e) {
                System.out.println("arquivo nao encontrado!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
