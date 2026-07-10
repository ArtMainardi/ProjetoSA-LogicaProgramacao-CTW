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
            sty.titulo("Gerenciador de Equipamentos e ");
        } while(option != 0);
    }
}