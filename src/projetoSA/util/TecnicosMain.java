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
        int codigo;

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
                    case 1: // Cadastrar um novo técnico:
                        tec = cadastrar();
                        // Envia o objeto criado para o service:
                        service.salvar(tec);
                        sty.quadro("Técnico criado com sucesso!");
                    Main.continuar();
                        break;
                    case 2: // Consultar técnico pelo código:
                        Main.clear();
                        sty.quadro("Consultar Técnico");
                        System.out.print("Digite o código do técnico: ");
                        codigo = Integer.parseInt(sc.nextLine().trim());
                        // Envia a requisição para o service:
                        tec = service.buscarId(codigo);
                        sty.titulo("Codigo | Nome | Matrícula | Setor | Telefone");
                        sty.lista(tec.detalhes());
                    Main.continuar();
                        break;
                    case 3: // Atualizar técnico:
                        Main.clear();
                        sty.quadro("Modificar Técnico");
                        System.out.print("Digite o código do técnico: ");
                        codigo = Integer.parseInt(sc.nextLine().trim());
                        // Procura o técnico pelo service:
                        tec = service.buscarId(codigo);
                        // Recebe novos dados:
                        tec = atualizar(tec);
                        // Envia a requisição para o service:
                        service.atualizar(tec, codigo);
                        sty.quadro("Técnico atualizado com sucesso!");
                    Main.continuar();
                        break;
                    case 4: // Excluir técnico pelo código:
                        Main.clear();
                        sty.quadro("Excluir Técnico");
                        System.out.print("Digite o código do técnico: ");
                        codigo = Integer.parseInt(sc.nextLine().trim());
                        // Envia a requisição para o service:
                        service.deletar(codigo);
                        sty.quadro("Técnico deletado com sucesso!");
                        Main.continuar();
                        break;
                    case 0: // Voltar
                        break;
                    default:
                        throw new Exception("ERRO: opção digitada inválida!");
                }
                Main.clear();
            } catch (Exception e) {
                sty.quadro(e.getMessage());
                Main.continuar();
                Main.clear();
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

    // Método que retorna 'Tecnico' com os novos dados para atualizar um técnico:
    public static Tecnico atualizar(Tecnico t){
        Main.clear();
        sty.quadro("Atualizar Técnico");

        // Recebe dados:
        System.out.print("Nome: " + t.getNome() + " -> ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: " + t.getMatricula() + " -> ");
        String matricula = sc.nextLine();
        System.out.print("Setor: " + t.getSetor() + " -> ");
        String setor = sc.nextLine();
        System.out.print("Telefone: " + t.getTelefone() + " -> ");
        String telefone = sc.nextLine();

        // Retorna objeto criado:
        return new Tecnico(nome, matricula, setor, telefone);
    }
}
