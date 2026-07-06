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
                throw new Exception("ERRO: não é permitido cadastrar uma manutenção para um equipamento inexistente!");
            }
            if(!tecnico.isObjectIntegrity()){
                throw new Exception("ERRO: não é permitido cadastrar uma manutenção para um técnico inexistente!");
            }
            if(equipamento.getStatus().equals("Em manutenção")){
                throw new Exception("ERRO: um equipamento que possui uma manutenção aberta não pode receber uma nova manutenção!");
            }
            this.equipamento = equipamento;
            this.tecnico = tecnico;
            this.dataAbertura = dataAbertura;
            this.dataEncerramento = dataEncerramento;
            this.tipoManutencao = tipoManutencao;
            this.descricao = descricao;
            this.situacao = situacao;
            objectIntegrity = true;
            equipamento.setStatus("Em manutenção");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // Construtor com ID (não precisa de verificação, pois recebe um objeto já criado da lista):
    public Manutencao(int codigo, Equipamento equipamento, Tecnico tecnico, String dataAbertura,
            String dataEncerramento, String tipoManutencao, String descricao, String situacao,
            boolean objectIntegrity) {
        this.codigo = codigo;
        this.equipamento = equipamento;
        this.tecnico = tecnico;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        this.tipoManutencao = tipoManutencao;
        this.descricao = descricao;
        this.situacao = situacao;
        this.objectIntegrity = objectIntegrity;
    }

    // Getters e Setters:
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    // --
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    // --
    public Tecnico getTecnico() {
        return tecnico;
    }
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    public String getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public String getDataEncerramento() {
        return dataEncerramento;
    }
    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    public String getTipoManutencao() {
        return tipoManutencao;
    }
    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public boolean isObjectIntegrity() {
        return objectIntegrity;
    }
    public void setObjectIntegrity(boolean objectIntegrity) {
        this.objectIntegrity = objectIntegrity;
    }
}
