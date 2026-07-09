package projetoSA.repository;

import java.util.ArrayList;
import java.util.List;
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
        return manutencoes.get(newId);
    }

    // READ:
    public List<Manutencao> read(){
        return manutencoes;
    }

    // READ (ID):
    public Manutencao readId(int id){
        // Procura a manutenção com o ID informado:
        for(Manutencao m : manutencoes){
            if(m.getCodigo() = id){
                
            }
        }
        return manutencoes.get(id);
    }

    // UPDATE:
    public Manutencao update(Manutencao modifiedManutencao){
        int id = modifiedManutencao.getCodigo();
        manutencoes.set(id, modifiedManutencao);
        return manutencoes.get(id);
    }

    // DELETE:
    public void delete(int id){
        manutencoes.remove(id);
    }
}
