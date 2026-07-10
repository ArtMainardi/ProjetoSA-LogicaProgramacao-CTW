package projetoSA.util;

import java.util.Scanner;
import projetoSA.Main;
import projetoSA.model.Equipamento;
import projetoSA.repository.Dados;
import projetoSA.service.EquipamentoService;

public class EquipamentosMain {
    // Variáveis:
    static Dados d;
    static Style sty;
    static Scanner sc;
    static EquipamentoService service;

    public static void equipamentos(Dados dados, Style style, Scanner scanner){
        // Define as variáveis da classe:
        d = dados;
        sty = style;
        sc = scanner;
        service = new EquipamentoService(d);
        // Outras variáveis:
        int codigo;
        Equipamento equip;

        // Menu de opções: 
        int option = -1;
        do{
            try{
                sty.titulo("Gerenciar Equipamentos");
                System.out.println("Digite uma opção: \n"
                                + "1- Cadastrar equipamento \n"
                                + "2- Consultar equipamento pelo código \n"
                                + "3- Alterar informações \n"
                                + "4- Excluir equipamento \n"
                                + "5- Listar todos os equipamentos cadastrados \n"
                                + "0- Voltar"
                );
                option = Integer.parseInt(sc.nextLine().trim());

                // Switch-case para analisar a resposta do usuário:
                switch (option) {
                    case 1: // Cadastrar um novo equipamento:
                        Equipamento novoEquipamento = cadastrar();
                        // Envia o objeto criado para o service:
                        service.adicionar(novoEquipamento);
                        sty.quadro("Equipamento criado com sucesso!");
                        Main.continuar();
                        break;
                    case 2: // Consultar equipamento pelo código:
                        Main.clear();
                        sty.quadro("Consultar Equipamento");
                        System.out.print("Digite o código do equipamento: ");
                        codigo = Integer.parseInt(sc.nextLine().trim());
                        // Envia a requisição para o service:
                        equip = service.buscarId(codigo);
                        sty.quadro(equip.getCodigo() + " | " + equip.getNome() + " | " + equip.getModelo() + " | " + equip.getStatus());
                        Main.continuar();
                        break;
                    case 3: // Atualizar equipamento:
                        Main.clear();
                        sty.quadro("Modificar Equipamento");
                        System.out.print("Digite o código do equipamento: ");
                        codigo = Integer.parseInt(sc.nextLine().trim());
                        // Envia a requisição para o service:
                        equip = service.buscarId(codigo);
                        Main.continuar();
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
        sty.quadro("Cadastrar Equipamento");

        // Recebe dados:
        System.out.print("Nome do novo equipamento: ");
        String nome = sc.nextLine();
        System.out.print("Categoria dele: ");
        String categoria = sc.nextLine();
        System.out.print("Fabricante dele: ");
        String fabricante = sc.nextLine();
        System.out.print("Modelo do novo equipamento: ");
        String modelo = sc.nextLine();
        System.out.print("Setor onde foi instalado: ");
        String nsetorInstalado = sc.nextLine();
        System.out.print("Data em que foi instalado (DD/MM/AAAA): ");
        String dataInstalado = sc.nextLine();
        System.out.print("Status desse equipamento ('Operando', 'Em manutencao' ou 'Inativo'): ");
        String status = sc.nextLine();

        // Retorna objeto criado:
        return new Equipamento(nome, categoria, fabricante, modelo, nsetorInstalado, dataInstalado, status);
    }

    // Método que retorna 'Equipamento' com os novos dados para atualizar um equipamento:
    public static Equipamento cadastrar(){
        Main.clear();
        sty.quadro("Cadastrar Equipamento");

        // Recebe dados:
        System.out.print("Nome do novo equipamento: ");
        String nome = sc.nextLine();
        System.out.print("Categoria dele: ");
        String categoria = sc.nextLine();
        System.out.print("Fabricante dele: ");
        String fabricante = sc.nextLine();
        System.out.print("Modelo do novo equipamento: ");
        String modelo = sc.nextLine();
        System.out.print("Setor onde foi instalado: ");
        String nsetorInstalado = sc.nextLine();
        System.out.print("Data em que foi instalado (DD/MM/AAAA): ");
        String dataInstalado = sc.nextLine();
        System.out.print("Status desse equipamento ('Operando', 'Em manutencao' ou 'Inativo'): ");
        String status = sc.nextLine();

        // Retorna objeto criado:
        return new Equipamento(nome, categoria, fabricante, modelo, nsetorInstalado, dataInstalado, status);
    }
}
