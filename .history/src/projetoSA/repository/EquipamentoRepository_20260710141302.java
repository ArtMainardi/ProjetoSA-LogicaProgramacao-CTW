package projetoSA.repository;

import java.util.ArrayList;
import java.util.List;
import projetoSA.model.Equipamento;

public class EquipamentoRepository {
    final ArrayList<Equipamento> equipamentos;
    final int nextId[];

    // Construtor:
    public EquipamentoRepository(Dados d){
        equipamentos = d.getEquipamentos();
        nextId = d.geteNextId();
    }

    // CREATE:
    public Equipamento create(Equipamento newEquipamento){
        int newId = nextId[0];
        nextId[0]++;
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
        // Procura equipamento com o ID informado:
        Equipamento equipamento = null;
        for(Equipamento e : equipamentos){
            if(e.getCodigo() == id){
                equipamento = e;
            }
        }
        return equipamento;
    }

    // UPDATE:
    public Equipamento update(Equipamento modifiedEquipamento){
        // Procura pelo objeto:
        int id = modifiedEquipamento.getCodigo();
        for(int cont = 0; cont < equipamentos.size(); cont++){
            if(equipamentos.get(cont).getCodigo() == id){
                equipamentos.get(cont) = modifiedEquipamento;
            }
        }
        return readId(id);
    }

    // DELETE:
    public void delete(int id){
        equipamentos.remove(readId(id));
    }
}
