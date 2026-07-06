package projetoSA.repository;

import java.util.ArrayList;
import java.util.List;
import projetoSA.model.Equipamento;

public class EquipamentoRepository {
    ArrayList<Equipamento> equipamentos = new ArrayList<>();
    int 

    // CREATE:
    public Equipamento create(Equipamento newEquipamento){
        int newId = equipamentos.size() + 1;
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
}
