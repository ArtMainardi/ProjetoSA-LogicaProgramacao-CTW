package projetoSA.util;

import java.util.Scanner;
import projetoSA.repository.Dados;

public class EquipamentosMain {
    public static void equipamentos(Dados d, Style sty, Scanner sc){
        int option;
        do{
            sty.titulo("Gerenciar Equipamentos");
            System.out.println("Digite uma opção: \n"
                            + "1- Cadastrar equipamento \n"
            );
            option = sc.nextInt();
        }while (option != 0);
    }
}
