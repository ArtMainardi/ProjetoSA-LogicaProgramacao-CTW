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
        return readId(newId);
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
        int id = modifiedEquipamento.getCodigo();
        equipamentos.set(id, modifiedEquipamento);
        return readId(id);
    }

    // DELETE:
    public void
}
