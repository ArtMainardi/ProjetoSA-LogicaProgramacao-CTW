package projetoSA.util;

import java.util.Scanner;
import projetoSA.Main;
import projetoSA.model.Manutencao;
import projetoSA.model.Tecnico;
import projetoSA.repository.Dados;
import projetoSA.service.TecnicoService;

public class ManutencoesMain {
    // Variáveis:
    static Dados d;
    static Style sty;
    static Scanner sc;
    static TecnicoService service;

    public static void manutencoes(Dados dados, Style style, Scanner scanner){
        // Define as variáveis da classe:
        d = dados;
        sty = style;
        sc = scanner;
        service = new TecnicoService(d);
        // Outras variáveis:
        int option = -1;

        // Menu de opções de manutenções:
        do {
            try {
                sty.titulo("Gerenciar Manutenção");
                System.out.println("Digite uma opção: \n"
                                + "1- Cadastrar manutenção \n"
                                + "2- Consultar manutenção pelo código \n"
                                + "3- Alterar situação da manutenção \n"
                                + "4- Finalizar manutenção \n"
                                + "5- Listar todas as manutenção cadastrados \n"
                                + "0- Voltar"
                );
                option = Integer.parseInt(sc.nextLine().trim()); // 'Integer.parseInt(sc.nextLine().trim())' para resolver 'quebra de linha perdida'

                // Switch-case para analisar a resposta do usuário:
                switch (option) {
                    case 0: // Cadastrar uma nova manutenção:

                        break;
                    default:
                        throw new Exception("ERRO: opção digitada inválida!");
                }
            } catch (Exception e) {
                sty.quadro(e.getMessage());
                Main.continuar();
                Main.clear();
            }
        } while (option != 0);
    }

    // Método que retorna nova manutenção cadastrada:
    public static Manutencao cadastrar(){
        Main.clear();
        sty.quadro("Cadastrar Manutenção");

        // Recebe dados:
        System.out.print("Código do equipamento relacionado: ");
        int eCodigo = sc.nextInt();
        
        System.out.print("Código do técnico relacionado: ");
        int tCodigo = sc.nextInt();
        System.out.print("Data de abertura da nova manutenção: ");
        String dataAbertura = sc.nextLine();
        System.out.print("Tipo da manutenção ('Preventiva' ou 'Corretiva'): ");
        String tipoManutencao = sc.nextLine();
        System.out.print("descricao dessa manutenção (0 para 'Sem descrição'): ");
        String descricao = sc.nextLine();
        System.out.print("Situação dela ('Aberta', 'Em andamento' ou 'Finalizada'): ");
        String situacao = sc.nextLine();

        // Retorna objeto criado:
        return new Manutencao(eCodigo, tCodigo, dataAbertura, tipoManutencao, descricao, situacao);
    }
}
