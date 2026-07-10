package projetoSA.util;

import java.util.Scanner;
import projetoSA.Main;
import projetoSA.model.Tecnico;
import projetoSA.repository.Dados;
import projetoSA.service.TecnicoService;

public class TecnicosMain {
    // Variáveis:
    static Dados d;
    static Style sty;
    static Scanner sc;
    static TecnicoService service;

    public static void tecnicos(Dados dados, Style style, Scanner scanner){
        // Define as variáveis da classe:
        d = dados;
        sty = style;
        sc = scanner;
        service = new TecnicoService(d);
        // Outras variáveis:
        int option = -1;
        Tecnico tec;

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
                        tec = cadastrar();
                        // Envia o objeto criado para o service:
                        service.salvar(tec);
                        sty.quadro("Técnico criado com sucesso!");
                        Main.continuar();
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

    // Método que retorna novo Tecnico cadastrado:
    public static Tecnico cadastrar(){
        Main.clear();
        sty.quadro("Cadastrar Técnico");

        // Recebe dados:
        System.out.print("Nome do novo técnico: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula do novo técnico: ");
        String matricula = sc.nextLine();
        System.out.print("Setor desse técnico: ");
        String setor = sc.nextLine();
        System.out.print("Telefone dele: ");
        String telefone = sc.nextLine();

        // Retorna objeto criado:
        return new Tecnico(nome, matricula, setor, telefone);
    }
}
