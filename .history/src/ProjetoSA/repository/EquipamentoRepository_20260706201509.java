package projetoSA.repository;

import java.util.ArrayList;
import projetoSA.model.Equipamento;

public class EquipamentoRepository {
    ArrayList<Equipamento> equipamentos = new ArrayList<>();

    // CREATE:
    public Equipamento create(Equipamento newEquipamento){
        int newId = equipamentos.size() + 1;
        newEquipamento.setCodigo(newId);
        equipamentos.add(newEquipamento);
        return equipamentos
    }
}
