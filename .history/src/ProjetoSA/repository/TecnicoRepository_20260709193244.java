package projetoSA.repository;

import java.util.ArrayList;
import java.util.List;
import projetoSA.model.Tecnico;

public class TecnicoRepository {
    private ArrayList<Tecnico> tecnicos;
    private int nextId;

    // Construtor:
    public TecnicoRepository(Dados d){
        tecnicos = 
    }

    // CREATE:
    public Tecnico create(Tecnico newTecnico){
        int newId = nextId;
        nextId++;
        newTecnico.setCodigo(newId);
        tecnicos.add(newTecnico);
        return readId(newId);
    }

    // READ:
    public List<Tecnico> read(){
        return tecnicos;
    }

    // READ (ID):
    public Tecnico readId(int id){
        // Procura técnico com o ID informado:
        Tecnico tecnico = null;
        for(Tecnico t : tecnicos){
            if(t.getCodigo() == id){
                tecnico = t;
            }
        }
        return tecnico;
    }

    // READ (MATRICULA):
    public Tecnico readMatricula(String matricula){
        // Percorre toda a lista para procurar o técnico com a matrícula informada:
        Integer id = null;
        for(Tecnico t : tecnicos){
            if(t.getMatricula().equals(matricula)){
                id = t.getCodigo();
            }
        }
        return readId(id);
    }

    // UPDATE:
    public Tecnico update(Tecnico modifiedTecnico){
        // Procura pelo técnico:
        int id = modifiedTecnico.getCodigo();
        for(Tecnico t : tecnicos){
            if(t.getCodigo() == id){
                t = modifiedTecnico;
            }
        }
        return readId(id);
    }

    // DELETE:
    public void delete(int id){
        tecnicos.remove(readId(id));
    }
}
