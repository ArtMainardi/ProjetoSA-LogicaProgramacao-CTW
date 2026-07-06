public class Equipamento {
    private int codigo;
    private String nome;
    private String categoria;
    private String fabricante;
    private String modelo;
    private String setorInstalado;
    private String dataInstalacao;
    private String status; // ('Operando', 'Em manutenção' ou 'Inativo')

    // Construtor:
    public Equipamento(int codigo, String nome, String categoria, String fabricante, String modelo,
            String setorInstalado, String dataInstalacao, String status) {
        try {
            if(nome.length() == 0 || categoria.length() == 0 || fabricante.length() == 0 || modelo.length() == 0 || 
                setorInstalado.length() == 0 || dataInstalacao.length() == 0 || status.length() == 0){
                throw new Exception("ERRO: não é permitido cadastrar equipamentos com algum dado vazio!");
            }
            if(!status.equals("Operando") && !status.equals("Em manutenção") && !status.equals("Inativo")){
                throw new Exception("ERRO: valor de 'status' inválido!");
            }
            this.codigo = codigo;
            this.nome = nome;
            this.categoria = categoria;
            this.fabricante = fabricante;
            this.modelo = modelo;
            this.setorInstalado = setorInstalado;
            this.dataInstalacao = dataInstalacao;
            this.status = status;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
}
