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

    // READ (EMAIL):
    public Tecnico readEmail(String email){
        // Percorre toda a lista para procurar o técnico com a matrícula informada:
        Integer id = null;
        for(int cont = 0; cont < tecnicos.size(); cont++){
            if(tecnicos.get(cont).getMatricula().equals(email)){
                id = 
            }
        }
        return tecnicos.get(id);
    }

    // UPDATE:
    public Tecnico update(Tecnico modifiedTecnico){
        int id = modifiedTecnico.getCodigo();
        tecnicos.set(id, modifiedTecnico);
        return tecnicos.get(id);
    }

    // DELETE:
    public void delete(int id){
        tecnicos.remove(id);
    }
}
