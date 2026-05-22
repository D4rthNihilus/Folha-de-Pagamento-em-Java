package a3uam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("====SISTEMA DE FOLHA DE PAGAMENTO====");
        System.out.println();

        List<Funcionario> listaDeFuncionarios = new ArrayList<>();

        //MENU INICIAL

        System.out.println("Seja bem vindo ao Sistema de Folha Pagamento em Java!");
        gerarMenuDeOpcoes();
        int opcao = sc.nextInt();
        
        while(opcao!=0){
            if(opcao <0 || opcao >3){//VALIDAÇÃO DA OPÇÃO ESCOLHIDA
                System.out.println("Opção inválida!");
                gerarMenuDeOpcoes();
                opcao = sc.nextInt();
            } else {
                System.out.print("Informe o número de registro do funcionário: ");
                int registro = sc.nextInt();

                while(validarRegistro(registro, listaDeFuncionarios)){//TESTA SE O NÚMERO DE REGISTRO JÁ ESTÁ EM USO
                    registro=sc.nextInt();
                }

                System.out.print("Informe o nome do funcionário: ");
                sc.nextLine();
                String nome = sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Informe a quantidade de horas extras: ");
                        double qtdExtras = sc.nextDouble();

                        while(!validarDecimal(qtdExtras)) {qtdExtras = sc.nextDouble();}

                        cadastrarFuncionarioPadrao(listaDeFuncionarios, registro, nome, qtdExtras);

                        System.out.println("Funcionáro padrão cadastrado com sucesso!");
                        break;
                    case 2:
                        System.out.print("Informe o valor total faturado nas vendas: ");
                        double faturamentoVendas = sc.nextDouble();

                        while(!validarDecimal(faturamentoVendas)){faturamentoVendas=sc.nextDouble();}

                        System.out.print("Informe o valor da comissão percentual por venda: ");
                        double comissaoPercentual = sc.nextDouble();

                        while(!validarDecimal(comissaoPercentual)){comissaoPercentual=sc.nextDouble();}

                        cadastrarFuncionarioComissionado(listaDeFuncionarios, registro, nome, faturamentoVendas, comissaoPercentual);

                        System.out.println("Funcionáro comissionado cadastrado com sucesso!");
                        break;
                    case 3:
                        System.out.print("Informe a quantidade de peças produzidas no mês: ");
                        int pecasProduzidas = sc.nextInt();

                        while(!validarInteiro(pecasProduzidas)){pecasProduzidas = sc.nextInt();}

                        System.out.print("Informe o valor por peça produzida: ");
                        double valorDaPeca = sc.nextDouble();

                        while(!validarDecimal(valorDaPeca)){valorDaPeca = sc.nextInt();}

                        cadastrarFuncionarioProducao(listaDeFuncionarios, registro, nome, pecasProduzidas, valorDaPeca);

                        System.out.println("Funcionáro produção cadastrado com sucesso!");
                        break;
                    default:
                        System.out.println("Erro: opção inválida!");
                        break;
                }

                gerarMenuDeOpcoes();
                System.out.println("Digite 4 para gerar folha de pagamento");
                opcao = sc.nextInt();

                if(opcao==4){
                    System.out.println();
                    System.out.println("Gerando folha de pagamento...");
                    for(Funcionario f : listaDeFuncionarios){
                        System.out.println(f.toString());
                    }
                    opcao=0;
                }
            }
        }
        System.out.println("Programa encerrado!");
        sc.close();
    }

    //CADASTRO DE FUNCIONARIO
    
    public static void cadastrarFuncionarioPadrao(List<Funcionario> lista, int registro, String nome, double horasExtras){
        Funcionario funcionario = new FuncionarioPadrao(registro, nome, horasExtras);
        lista.add(funcionario);
    }

    public static void cadastrarFuncionarioComissionado(List<Funcionario> lista, int registro, String nome, double valorDasVendas, double comissaoPercentual){
        Funcionario funcionario = new FuncionarioComissionado(registro, nome, valorDasVendas, comissaoPercentual);
        lista.add(funcionario);
    }

    public static void cadastrarFuncionarioProducao(List<Funcionario> lista, int registro, String nome, int pecasProduzidas, double valorDaPeca){
        Funcionario funcionario = new FuncionarioProducao(registro, nome, pecasProduzidas, valorDaPeca);
        lista.add(funcionario);
    }

    //VALIDAÇÃO DE DADOS

    public static boolean validarDecimal(double decimal){
        if(decimal < 0.0){
            System.out.print("Número inválido! Digite novamente: ");
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarInteiro(int inteiro){
        if(inteiro < 0.0){
            System.out.print("Número inválido! Digite novamente: ");
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarRegistro(int registro, List<Funcionario> lista){
        boolean b = false;
        if(registro<0){
            b = true;
            System.out.print("Número inválido! Digite novamente: ");
        } else {
            for(Funcionario f : lista){
                if(f.getNumeroDeRegistro()==registro){
                    System.out.print("O número de registro já está em uso! Tente novamente: ");
                    b = true;
                }
            }
        }
        return b;
    }

    public static void gerarMenuDeOpcoes(){
        System.out.println();
        System.out.println("Digite 0 para sair do programa");
        System.out.println("Digite 1 para cadrastar um novo funcionário padrão");
        System.out.println("Digite 2 para cadrastar um novo funcionário comissionado");
        System.out.println("Digite 3 para cadrastrar um novo funcionário produção");       
    }
}