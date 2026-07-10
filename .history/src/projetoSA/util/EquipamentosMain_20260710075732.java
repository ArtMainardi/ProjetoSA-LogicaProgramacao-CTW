package projetoSA.util;

import java.util.Scanner;

import projetoSA.Main;
import projetoSA.repository.Dados;

public class EquipamentosMain {
    public static void equipamentos(Dados d, Style sty, Scanner sc){
        // Menu de opções: 
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

            // Switch-case com try-catch para analisar a resposta do usuário:
            try{
                switch (option) {
                    case 1:
                        break;
                    case 0:
                        break;
                    default:
                        throw new Exception("ERRO: opção digitada inválida!");
                }
                Main.clear();
            } catch(Exception e){
                sty.quadro(e.getMessage());
                Main.continuar();
                Main.clear();
            }
        }while (option != 0);
    }
}
