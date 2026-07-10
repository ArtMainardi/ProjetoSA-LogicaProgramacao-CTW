package projetoSA;

import java.util.Scanner;

import projetoSA.repository.Dados;
import projetoSA.util.EquipamentosMain;
import projetoSA.util.Style;

public class Main {
    // Variáveis:
    static Dados dados = new Dados();
    static Style sty = new Style();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
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
                                + "0- Sair \n"
                );
                option = Integer.par;
                sc.nextLine();

                // Switch-case com try-catch para analisar a resposta do usuário:
                switch (option) {
                    case 1:
                        clear();
                        // Direciona para o bloco/menu dos equipamentos:
                        EquipamentosMain.equipamentos(dados, sty, sc);
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
}