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
                            + "2- Consultar equipamento pelo código \n"
                            + "3- Alterar informações \n"
                            + "4- Excluir equipamento \n"
                            + "5- Listar todos os equipamentos cadastrados \n"
                            + "0- Voltar"
            );
            option = sc.nextInt();
        }while (option != 0);
    }
}
