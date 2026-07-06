package projetoSA.model;

public class Tecnico {
    private int codigo;
    private String nome;
    private String matricula;
    private String setor;
    private String telefone;
    /
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
}
