package projetoSA.service;

import projetoSA.model.Tecnico;
import projetoSA.repository.TecnicoRepository;

public class TecnicoService {
    TecnicoRepository repository = new TecnicoRepository();

    // Salvar:
    public Tecnico salvar(Tecnico newTecnico){
        if(newTecnico.getNome().trim().isEmpty() || newTecnico.getMatricula().trim().isEmpty()){
            throw new RuntimeException("ERRO: ");
        }

        Tecnico 
        return repos;
    }
}
