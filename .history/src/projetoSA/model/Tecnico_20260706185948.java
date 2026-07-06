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
    
    
}
