package projetoSA.repository;

import java.util.ArrayList;
import java.util.List;
import projetoSA.model.Equipamento;

public class EquipamentoRepository {
    ArrayList<Equipamento> equipamentos = new ArrayList<>();
    int nextId = 0;

    // CREATE:
    public Equipamento create(Equipamento newEquipamento){
        int newId = nextId;
        nextId++;
        newEquipamento.setCodigo(newId);
        equipamentos.add(newEquipamento);
        return newEquipamento;
    }

    // READ:
    public List<Equipamento> read(){
        return equipamentos;
    }

    // READ (ID):
    public Equipamento readId(int id){
        return equipamentos.get(id);
    }

    // UPDATE:
    public Equipamento update(Equipamento modifiedEquipamento){
        equipamentos.get(nextId)
    }
}
