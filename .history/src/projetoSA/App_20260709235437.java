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
            
        } while(option != 0);
    }
}