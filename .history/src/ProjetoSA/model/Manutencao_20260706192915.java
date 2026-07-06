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
    // Verifica criação do objeto:
    private boolean objectIntegrity = false;

    // Construtor sem ID (cria um novo objeto com o ID gerado pelo repository):
    public Manutencao(Equipamento equipamento, Tecnico tecnico, String dataAbertura, String dataEncerramento,
            String tipoManutencao, String descricao, String situacao) {
        try {
            if(equipamento.isObjectIntegrity())
            this.equipamento = equipamento;
            this.tecnico = tecnico;
            this.dataAbertura = dataAbertura;
            this.dataEncerramento = dataEncerramento;
            this.tipoManutencao = tipoManutencao;
            this.descricao = descricao;
            this.situacao = situacao;
            objectIntegrity = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
