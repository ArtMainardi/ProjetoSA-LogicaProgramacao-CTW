package projetoSA;

import java.util.Scanner;

import projetoSA.repository.Dados;
import projetoSA.util.Style;

public class App {
    // Variáveis:
    static Dados dados = new Dados();
    static Style sty = new Style();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int option;
        do{
            sty.titulo("Gerenciador de Equipamentos e Manutenções");
            System.out.println("Digite uma opção: \n"
                            + "1- Gerenciamento de Equipamentos \n"
                            + "2- Gerenciamento  de Técnicos \n"
                            + "3- Controle de Manutenções \n"
                            + "4- Relatórios \n"
                            + "0- Sair \n"
            );
            option = sc.nextInt();

            try{
                switch (option) {
                    case 1:
                        break;
                    case 0:
                        break;
                    default:
                        throw new Exception("ERRO: opção digitada inválida!");
                }
            } catch(Exception e){
                sty.quadro(e.getMessage());
            }
        } while(option != 0);
    }

    // Procedimento que pede confirmação para o usuário para então continuar com o programa:
    public void continuar(){
        System.out.println("Pressione ENTER para continuar..");
        sc.nextLine();
    }

    // Procedimento que limpa a tela:
    public void clear(){
        
    }
}