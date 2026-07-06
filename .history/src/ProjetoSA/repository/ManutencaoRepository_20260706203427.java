package projetoSA.repository;

import java.util.ArrayList;
import projetoSA.model.Manutencao;

public class ManutencaoRepository {
    ArrayList<Manutencao> manutencoes = new ArrayList<>();
    int nextId = 0;

    // CREATE:
    public Manutencao create(Manutencao newManutencao){
        int newId = nextId;
        nextId++;
        newManutencao.setCodigo(newId);
        manutencoes.add(newManutencao);
        return manutencoes.get(newId)
    }
}
