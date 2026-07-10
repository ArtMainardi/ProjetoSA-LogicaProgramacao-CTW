package projetoSA.util;

import java.util.Scanner;
import projetoSA.Main;
import projetoSA.model.Equipamento;
import projetoSA.model.Manutencao;
import projetoSA.model.Tecnico;
import projetoSA.repository.Dados;
import projetoSA.service.EquipamentoService;
import projetoSA.service.ManutencaoService;
import projetoSA.service.TecnicoService;

public class ManutencoesMain {
    // Variáveis:
    static Dados d;
    static Style sty;
    static Scanner sc;
    static ManutencaoService service;
    static TecnicoService tService;
    static EquipamentoService eService;

    public static void manutencoes(Dados dados, Style style, Scanner scanner){
        // Define as variáveis da classe:
        d = dados;
        sty = style;
        sc = scanner;
        service = new ManutencaoService(d);
        tService = new TecnicoService(d);
        eService = new EquipamentoService(d);
        // Outras variáveis:
        int option = -1;
        Manutencao m;
        int codigo;

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
                    case 1: // Cadastrar uma nova manutenção:
                        m = cadastrar();
                        // Envia o objeto criado para o service:
                        service.salvar(m);
                        sty.quadro("Manutenção criada com sucesso!");
                        Main.continuar();
                        break;
                    case 2: // Consultar técnico pelo código:
                        Main.clear();
                        sty.quadro("Consultar Manutenção");
                        System.out.print("Digite o código da manutenção: ");
                        codigo = Integer.parseInt(sc.nextLine().trim());
                        // Envia a requisição para o service:
                        m = service.buscarId(codigo);
                        sty.titulo("Codigo | Nome Equipamento (ID) | Nome Técnico (ID) | Data Abertura | Data Encerramento | Tipo | Situação | Descrição");
                        sty.lista(m.detalhes());
                        Main.continuar();
                        break;
                    case 3: // Alterar situação da manutenção:
                        Main.clear();
                        sty.quadro("Alterar Situação da Manutenção");
                        System.out.print("Digite o código da manutenção: ");
                        codigo = Integer.parseInt(sc.nextLine().trim());
                        // Envia a requisição para o service:
                        m = service.buscarId(codigo);
                        service.modificarStatus(codigo, "status");
                        break;
                    case 0:
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

    // Método que retorna nova manutenção cadastrada:
    public static Manutencao cadastrar(){
        Main.clear();
        sty.quadro("Cadastrar Manutenção");

        // Recebe dados:
        // Procura pelo equipamento:
        System.out.print("Código do equipamento relacionado: ");
        int eCodigo = Integer.parseInt(sc.nextLine().trim());
        Equipamento equipamento = eService.buscarId(eCodigo);

        // Procura pelo técnico:
        System.out.print("Código do técnico relacionado: ");
        int tCodigo = Integer.parseInt(sc.nextLine().trim());
        Tecnico tecnico = tService.buscarId(tCodigo);

        System.out.print("Data de abertura da nova manutenção: ");
        String dataAbertura = sc.nextLine();
        System.out.print("Tipo da manutenção ('Preventiva' ou 'Corretiva'): ");
        String tipoManutencao = sc.nextLine();

        // Verifica descrição:
        System.out.print("Descricao dessa manutenção (0 para 'Sem descrição'): ");
        String descricao = sc.nextLine();
        if(descricao.equals("0")){
            descricao = "Sem descrição";
        }

        System.out.print("Situação dela ('Aberta', 'Em andamento' ou 'Finalizada'): ");
        String situacao = sc.nextLine();

        // Retorna objeto criado:
        return new Manutencao(equipamento, tecnico, dataAbertura, tipoManutencao, descricao, situacao);
    }
}
