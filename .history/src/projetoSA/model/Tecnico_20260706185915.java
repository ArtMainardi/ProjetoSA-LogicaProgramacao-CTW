package projetoSA.model;

public class Tecnico {
    private int codigo;
    private String nome;
    private String matricula;
    private String setor;
    private String telefone;

    // Construtor sem ID:
    public Tecnico(String nome, String matricula, String setor, String telefone) {
        try {
            
        } catch (Exception e) {
        }
        this.nome = nome;
        this.matricula = matricula;
        this.setor = setor;
        this.telefone = telefone;
    }
    
}
