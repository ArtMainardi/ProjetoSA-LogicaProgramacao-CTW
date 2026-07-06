package projetoSA.model;

public class Manutencao {
    private int codigo;
    private Equipamento equipamento;
    private Tecnico tecnico;
    private String dataAbertura;
    private String dataEncerramento;
    private String tipoManutencao; // (Preventiva ou Corretiva)
    private String descricao;
    private String situacao; // (Aberta, Em andamento ou Finalizada)

    // Construtor sem ID (cria um novo objeto com o ID gerado pelo repository):
}
