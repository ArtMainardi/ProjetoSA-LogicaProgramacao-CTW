package projetoSA.repository;

import java.util.ArrayList;
import projetoSA.model.Equipamento;
import projetoSA.model.Manutencao;
import projetoSA.model.Tecnico;

public class Dados {
    // Equipamentos:
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    private int eNextId[] = {0};

    // Técnicos:
    private ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private int tNextId[] = {0};

    // Manutenções:
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();
    private int mNextId[] = {0};


    // Getters e Setters:
    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }
    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
    // --
    public int[] geteNextId() {
        return eNextId;
    }
    public void seteNextId(int eNextId[]) {
        this.eNextId = eNextId;
    }
    // --
    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }
    public void setTecnicos(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }
    // --
    public int[] gettNextId() {
        return tNextId;
    }
    public void settNextId(int tNextId[]) {
        this.tNextId = tNextId;
    }
    // --
    public ArrayList<Manutencao> getManutencoes() {
        return manutencoes;
    }
    public void setManutencoes(ArrayList<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }
    // --
    public int[] getmNextId() {
        return mNextId;
    }
    public void setmNextId(int mNextId[]) {
        this.mNextId = mNextId;
    }
}
