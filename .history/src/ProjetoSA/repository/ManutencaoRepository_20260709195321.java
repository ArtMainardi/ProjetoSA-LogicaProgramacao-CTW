package projetoSA.repository;

import java.util.ArrayList;
import java.util.List;
import projetoSA.model.Manutencao;

public class ManutencaoRepository {
    private ArrayList<Manutencao> manutencoes;
    private int nextId[];

    // Construtor:
    public ManutencaoRepository(Dados d){
        manutencoes = d.getManutencoes();
        nextId = d.getmNextId();
    }

    // CREATE:
    public Manutencao create(Manutencao newManutencao){
        int newId = nextId[0];
        nextId[0]++;
        newManutencao.setCodigo(newId);
        manutencoes.add(newManutencao);
        return readId(newId);
    }

    // READ:
    public List<Manutencao> read(){
        return manutencoes;
    }

    // READ (ID):
    public Manutencao readId(int id){
        // Procura a manutenção com o ID informado:
        for(Manutencao m : manutencoes){
            if(m.getCodigo() == id){
                return m;
            }
        }
        return null;
    }

    // UPDATE:
    public Manutencao update(Manutencao modifiedManutencao){
        // Procura pela manutenção:
        int id = modifiedManutencao.getCodigo();
        for(Manutencao m : manutencoes){
            if(m.getCodigo() == id){
                m = modifiedManutencao;
            }
        }
        return readId(id);
    }

    // DELETE:
    public void delete(int id){
        manutencoes.remove(readId(id));
    }
}
