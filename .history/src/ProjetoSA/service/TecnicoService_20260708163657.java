package projetoSA.service;

import projetoSA.model.Tecnico;
import projetoSA.repository.TecnicoRepository;

public class TecnicoService {
    TecnicoRepository repository = new TecnicoRepository();

    // Salvar:
    public Tecnico salvar(Tecnico newTecnico){
        // Verificando dados:
        if(newTecnico.getNome().trim().isEmpty() || newTecnico.getMatricula().trim().isEmpty() || 
                newTecnico.getSetor().trim().isEmpty() || newTecnico.getMatricula().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar técnicos com algum dado vazio!");
        }

        // Salvando:
        Tecnico tecnico = repository.create(newTecnico);
        return tecnico;
    }
}
