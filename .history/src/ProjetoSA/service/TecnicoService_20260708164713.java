package projetoSA.service;

import projetoSA.model.Tecnico;
import projetoSA.repository.TecnicoRepository;

public class TecnicoService {
    TecnicoRepository repository = new TecnicoRepository();

    // Salvar:
    public Tecnico salvar(Tecnico newTecnico){
        // Verificando dados:
        if(newTecnico.getNome().trim().isEmpty() || newTecnico.getMatricula().trim().isEmpty() || 
                newTecnico.getSetor().trim().isEmpty() || newTecnico.getTelefone().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar técnicos com algum dado vazio!");
        }

        // Verificando uniquidade de 'matricula':
        if(repository.readMatricula(newTecnico.getMatricula()) != null){
            throw new RuntimeException("ERRO: já existe um técnico com essa matrícula!");
        }

        // Salvando:
        return repository.create(newTecnico);
    }
}
