package projetoSA.repository;

import java.util.ArrayList;
import java.util.List;
import projetoSA.model.Tecnico;

public class TecnicoRepository {
    ArrayList<Tecnico> tecnicos = new ArrayList<>();
    int nextId = 0;

    // CREATE:
    public Tecnico create(Tecnico newTecnico){
        int newId = nextId;
        nextId++;
        newTecnico.setCodigo(newId);
        tecnicos.add(newTecnico);
        return tecnicos.get(newId);
    }

    // READ:
    public List<Tecnico> read(){
        return tecnicos;
    }

    // READ (ID):
    public Tecnico readId(int id){
        return tecnicos.get(id);
    }

    // UPDATE:
    public Tecnico update(Tecnico modifiedTecnico){
        int id = modifiedTecnico.getCodigo();
        
    }
}
