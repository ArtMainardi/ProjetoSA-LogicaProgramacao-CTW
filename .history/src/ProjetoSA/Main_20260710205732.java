package projetoSA;

import java.util.Scanner;
import projetoSA.repository.Dados;
import projetoSA.util.EquipamentosMain;
import projetoSA.util.ManutencoesMain;
import projetoSA.util.Relatorio;
import projetoSA.util.Style;
import projetoSA.util.TecnicosMain;

public class Main {
    // Variáveis:
    static Dados dados = new Dados();
    static Style sty = new Style();
    static Scanner sc = new Scanner(System.in);
    // Relatório:
    static Relatorio relatorio = new Relatorio(dados);

    public static void main(String[] args) throws Exception {
        // Definindo variáveis do relatório:

        // Menu de opções:
        int option = -1;
        do{
            try{
                sty.titulo("Gerenciador de Equipamentos e Manutenções");
                System.out.println("Digite uma opção: \n"
                                + "1- Gerenciamento de Equipamentos \n"
                                + "2- Gerenciamento  de Técnicos \n"
                                + "3- Controle de Manutenções \n"
                                + "4- Relatórios \n"
                                + "0- Sair"
                );
                option = Integer.parseInt(sc.nextLine().trim());

                // Switch-case com try-catch para analisar a resposta do usuário:
                switch (option) {
                    case 1:
                        clear();
                        // Direciona para o bloco/menu dos equipamentos:
                        EquipamentosMain.equipamentos(dados, sty, sc, relatorio);
                        break;
                    case 2:
                        clear();
                        // Direciona para o bloco/menu dos técnicos:
                        TecnicosMain.tecnicos(dados, sty, sc, relatorio);
                        break;
                    case 3:
                        clear();
                        // Direciona para o bloco/menu das manutenções:
                        ManutencoesMain.manutencoes(dados, sty, sc, relatorio);
                        break;
                    case 4:
                        
                        break;
                    case 0:
                        break;
                    default:
                        throw new Exception("ERRO: opção digitada inválida!");
                }
                clear();
            } catch(Exception e){
                sty.quadro(e.getMessage());
                continuar();
                clear();
            }
        } while(option != 0);
    }

    // Procedimento que pede confirmação para o usuário para então continuar com o programa:
    public static void continuar(){
        System.out.println("Pressione ENTER para continuar..");
        sc.nextLine();
    }

    // Procedimento que limpa a tela:
    public static void clear(){
        for(int cont = 0; cont < 20; cont++){
            System.out.println();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n\n");
    }

    // Procedimento que mostra relatório na tela:
    public static void mostrarRelatorio(){
        relatorio.atualizarRelatorio();

        clear();
        sty.titulo("Relatório");
        System.out.println("Total de equipamentos cadastrados: " + relatorio.getQtdEquipamentos());
        System.out.println("Total de técnicos cadastrados: " + relatorio.getQtdEquipamentos());
    }
}