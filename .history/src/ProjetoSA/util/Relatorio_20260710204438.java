package projetoSA.util;

import java.util.List;
import projetoSA.model.Equipamento;
import projetoSA.repository.Dados;
import projetoSA.service.EquipamentoService;

public class Relatorio {
    private int qtdEquipamentos = 0; // Quantidade total de equipamentos cadastrados
    private int qtdTecnicos = 0; // Quantidade total de técnicos cadastrados
    private int equipManutencao = 0; // Equipamentos em manutenção
    private int equipAtivos = 0; // Equipamentos ativos
    private int equipInativos = 0; // Equipamentos inativos
    private int manAbertas = 0; // Quantidade de manutenções abertas
    private int manFinalizadas = 0; // Quantidade de manutenções finalizadas
    private Dados dados;

    public Relatorio(Dados d){
        dados = d;
    }

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
    // --
    public int getManFinalizadas() {
        return manFinalizadas;
    }
    public void setManFinalizadas(int manFinalizadas) {
        this.manFinalizadas = manFinalizadas;
    }

    // Métodos:
    public void atualizarRelatorio(){
        EquipamentoService eService = new EquipamentoService(dados);
        
        List<Equipamento> equipamentos = eService.listar();
        int qtdManutencao = 0;
        int qtdAtivos = 0;
        for(Equipamento e : equipamentos){
            if(e.getStatus().equals("Em manutencao")){
                qtdManutencao++;
            }
            if(e.getStatus().equals("Operando"))
        }
        // Atualiza equipamentos em manutenção:
        equipManutencao = qtdManutencao;
         // Atualiza equipamentos ativos:
    }
}
