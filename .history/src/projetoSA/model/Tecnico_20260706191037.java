package projetoSA.model;

public class Tecnico {
    private int codigo;
    private String nome;
    private String matricula;
    private String setor;
    private String telefone;
    // Verifica criação do objeto:
    private boolean objectIntegrity = true;

    // Construtor sem ID (cria um novo objeto):
    public Tecnico(String nome, String matricula, String setor, String telefone) {
        try {
            if(nome.trim().isEmpty() || matricula.trim().isEmpty() || setor.trim().isEmpty() || telefone.trim().isEmpty()){
                throw new Exception("ERRO: não é permitido cadastrar técnicos com algum dado vazio!");
            }
            this.nome = nome;
            this.matricula = matricula;
            this.setor = setor;
            this.telefone = telefone;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            objectIntegrity = false;
        }
    }
    // Construtor com ID (não precisa de verificação, pois recebe um objeto já criado da lista):
    public Tecnico(int codigo, String nome, String matricula, String setor, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;
        this.telefone = telefone;
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
    public boolean isObjectIntegrity() {
        return objectIntegrity;
    }
    public void setObjectIntegrity(boolean objectIntegrity) {
        this.objectIntegrity = objectIntegrity;
    }
}
