package projetoSA.util;

import java.util.Scanner;
import projetoSA.Main;
import projetoSA.model.Equipamento;
import projetoSA.repository.Dados;

public class EquipamentosMain {
    // Variáveis:
    static Scanner sc;
    static Style sty;
    static 

    public static void equipamentos(Dados d, Style style, Scanner scanner){
        // Define as variáveis da classe:
        sc = scanner;
        sty = style;

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
            sc.nextLine();

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

    // Método que retorna novo Equipamento cadastrado:
    public static Equipamento cadastrar(){
        Main.clear();
        
        System.out.println("");
    }
}
