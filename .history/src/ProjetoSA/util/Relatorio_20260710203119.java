package projetoSA.util;

public class Relatorio {
    private int qtdEquipamentos = 0; // Quantidade total de equipamentos cadastrados
    private int qtdTecnicos = 0; // Quantidade total de técnicos cadastrados
    private int equipManutencao = 0; // Equipamentos em manutenção
    private int equipAtivos = 0; // Equipamentos ativos
    private int equipInativos = 0; // Equipamentos inativos
    private int manAbertas = 0; // Quantidade de manutenções abertas
    private int manFinalizadas = 0; // Quantidade de manutenções finalizadas

    // Getters e Setters:
    public int getQtdEquipamentos() {
        return qtdEquipamentos;
    }
    public void setQtdEquipamentos(int qtdEquipamentos) {
        this.qtdEquipamentos = qtdEquipamentos;
    }
    // --
    public int getQtdTecnicos() {
        return qtdTecnicos;
    }
    public void setQtdTecnicos(int qtdTecnicos) {
        this.qtdTecnicos = qtdTecnicos;
    }
    // --
    public int getEquipManutencao() {
        return equipManutencao;
    }
    public void setEquipManutencao(int equipManutencao) {
        this.equipManutencao = equipManutencao;
    }
    // --
    public int getEquipAtivos() {
        return equipAtivos;
    }
    public void setEquipAtivos(int equipAtivos) {
        this.equipAtivos = equipAtivos;
    }
    // --
    public int getEquipInativos() {
        return equipInativos;
    }
    public void setEquipInativos(int equipInativos) {
        this.equipInativos = equipInativos;
    }
    // --
    public int getManAbertas() {
        return manAbertas;
    }
    public void setManAbertas(int manAbertas) {
        this.manAbertas = manAbertas;
    }
    public int getManFinalizadas() {
        return manFinalizadas;
    }
    public void setManFinalizadas(int manFinalizadas) {
        this.manFinalizadas = manFinalizadas;
    }
}
