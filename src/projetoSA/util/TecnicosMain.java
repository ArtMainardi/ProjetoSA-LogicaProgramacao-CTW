package projetoSA.util;

import java.util.Scanner;
import projetoSA.repository.Dados;
import projetoSA.service.EquipamentoService;

public class TecnicosMain {
    // Variáveis:
    static Dados d;
    static Style sty;
    static Scanner sc;
    static EquipamentoService service;

    public static void tecnicos(Dados dados, Style style, Scanner scanner){
        // Define as variáveis da classe:
        d = dados;
        sty = style;
        sc = scanner;
        service = new EquipamentoService(d);
        // Outras variáveis:
        int option = -1;

        // Menu de opções de técnicos:
        do {
            try {
                sty.titulo("Gerenciar Técnicos");
                System.out.println("Digite uma opção: \n"
                                + "1- Cadastrar técnico \n"
                                + "2- Consultar técnico pelo código \n"
                                + "3- Alterar informações \n"
                                + "4- Excluir técnico \n"
                                + "5- Listar todos os técnicos cadastrados \n"
                                + "0- Voltar"
                );
                option = Integer.parseInt(sc.nextLine().trim()); // 'Integer.parseInt(sc.nextLine().trim())' para resolver 'quebra de linha perdida'

                // Switch-case para analisar a resposta do usuário:
                switch (option) {
                    case 1:
                        break;
                    case 0: // Voltar
                        break;
                    default:
                        throw new Exception("ERRO: opção digitada inválida!");
                }
            } catch (Exception e) {
                sty.quadro(e.getMessage());
            }
        } while (option != 0);
    }
}
