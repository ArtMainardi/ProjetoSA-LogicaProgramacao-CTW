package projetoSA.repository;

import java.util.ArrayList;
import projetoSA.model.Tecnico;

public class TecnicoRepository {
    ArrayList<Tecnico> tecnicos = new ArrayList<>();
    int nextId = 0;

    // CREATE:
    public Tecnico create(Tecnico newTecnico){
        int newId = nextId;
        nextId++;
        tecnicos.add(newTecnico);
    }
}
