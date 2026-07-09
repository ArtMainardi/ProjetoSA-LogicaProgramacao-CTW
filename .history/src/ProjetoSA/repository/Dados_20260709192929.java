package projetoSA.repository;

import java.util.ArrayList;
import projetoSA.model.Equipamento;
import projetoSA.model.Manutencao;
import projetoSA.model.Tecnico;

public class Dados {
    // Equipamentos:
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    private int eNextId = 0;

    // Técnicos:
    private ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private int nextId = 0;

    // Manutenções:
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();
    private int nextId = 0;
}
