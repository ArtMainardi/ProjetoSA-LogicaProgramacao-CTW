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
            if(!equipamento.isObjectIntegrity()){ 
                throw new Exception("ERRO: não é permitido cadastrar uma manutenção para um equipamento inexistente");
            }
            if(!tecnico.isObjectIntegrity()){
                throw new Exception("ERRO: não é permitido cadastrar uma manutenção para um técnico inexistente");
            }
            if(equipamento.getStatus().equals("Em manutenção")){
                throw new Exception("ERRO: equipamento que possuir uma manutenção aberta não poderá receber uma nova manutenção");
            }
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
