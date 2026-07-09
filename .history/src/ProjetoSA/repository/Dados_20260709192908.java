package projetoSA.repository;

import java.util.ArrayList;
import projetoSA.model.Equipamento;
import projetoSA.model.Manutencao;

public class Dados {
    // Equipamentos:
    private ArrayList<Equipamento> equipamentos = new ArrayList<>();
    private int eNextId = 0;

    // Manutenções:
    private ArrayList<Manutencao> manutencoes = new ArrayList<>();
    private int nextId = 0;
}
