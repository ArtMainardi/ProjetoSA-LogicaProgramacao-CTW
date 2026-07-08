package projetoSA.service;

import java.util.List;
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

        return repository.create(newTecnico);
    }

    // Listar:
    public List<Tecnico> listar(){
        // Verifica se a lista não está vazia:
        List<Tecnico> tecnicos = repository.read();
        if(tecnicos.isEmpty()){
            throw new RuntimeException("Nenhum técnico salvo!");
        }
        
        return tecnicos;
    }

    // Buscar (ID):
    public Tecnico buscarId(int id){
        // Verifica se encontrou um dado:
        Tecnico tecnico = repository.readId(id);
        if(tecnico == null){
            throw new RuntimeException("ERRO: nenhum técnico com esse ID encontrado!");
        }

        return tecnico;
    }

    // Buscar (matrícula):
    public Tecnico buscarMatricula(String matricula){
        // Verifica se encontrou um dado:
        Tecnico tecnico = repository.readMatricula(matricula);
        if(tecnico == null){
            throw new RuntimeException("ERRO: nenhum técnico com essa matrícula encontrado!");
        }

        return tecnico;
    }

    // Atualizar:
    public Tecnico atualizar(Tecnico newTecnico, int id){
        // Verifica se encontrou um dado:
        Tecnico tecnico = repository.readId(id);
        if(tecnico == null){
            throw new RuntimeException("ERRO: nenhum técnico com esse ID encontrado!");
        }

        if(newTecnico.getNome().trim().isEmpty() || newTecnico.getMatricula().trim().isEmpty() || 
                newTecnico.getSetor().trim().isEmpty() || newTecnico.getTelefone().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar técnicos com algum dado vazio!");
        }

        // Verificando uniquidade de 'matricula':
        if(repository.readMatricula(newTecnico.getMatricula()) != null){
            throw new RuntimeException("ERRO: já existe um técnico com essa matrícula!");
        }
    }
}
