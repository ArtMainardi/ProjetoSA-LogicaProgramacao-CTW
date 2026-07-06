package projetoSA.model;
public class Equipamento {
    private int codigo;
    private String nome;
    private String categoria;
    private String fabricante;
    private String modelo;
    private String setorInstalado;
    private String dataInstalacao;
    private String status; // ('Operando', 'Em manutenção' ou 'Inativo')

    // Construtor sem ID (cria um novo objeto com o ID gerado pelo repository):
    public Equipamento(String nome, String categoria, String fabricante, String modelo,
            String setorInstalado, String dataInstalacao, String status) {
        this.nome = nome;
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.setorInstalado = setorInstalado;
        this.dataInstalacao = dataInstalacao;
        this.status = status;
    }
    // Construtor com ID (recebe um objeto já criado da lista):
    public Equipamento(int codigo, String nome, String categoria, String fabricante, String modelo,
            String setorInstalado, String dataInstalacao, String status, boolean objectIntegrity) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.setorInstalado = setorInstalado;
        this.dataInstalacao = dataInstalacao;
        this.status = status;
    }

    // Getters e Setters:
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    // --
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    // --
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    // --
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    // --
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    // --
    public String getSetorInstalado() {
        return setorInstalado;
    }
    public void setSetorInstalado(String setorInstalado) {
        this.setorInstalado = setorInstalado;
    }
    // --
    public String getDataInstalacao() {
        return dataInstalacao;
    }
    public void setDataInstalacao(String dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }
    // --
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    // --
    public boolean isObjectIntegrity() {
        return objectIntegrity;
    }
    public void setObjectIntegrity(boolean objectIntegrity) {
        this.objectIntegrity = objectIntegrity;
    }
}
