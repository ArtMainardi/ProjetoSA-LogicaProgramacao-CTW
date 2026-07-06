package projetoSA.model;

public class Tecnico {
    private int codigo;
    private String nome;
    private String matricula;
    private String setor;
    private String telefone;

    // Construtor sem ID (cria um novo objeto):
    public Tecnico(String nome, String matricula, String setor, String telefone) {
        try {
            this.nome = nome;
            this.matricula = matricula;
            this.setor = setor;
            this.telefone = telefone;
        } catch (Exception e) {
        }
    }
    // Construtor com ID (recebe objeto já criado da lista):

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
