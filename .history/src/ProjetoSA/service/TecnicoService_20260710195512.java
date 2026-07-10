package projetoSA.service;

import java.util.List;
import projetoSA.model.Manutencao;
import projetoSA.model.Tecnico;
import projetoSA.repository.Dados;
import projetoSA.repository.ManutencaoRepository;
import projetoSA.repository.TecnicoRepository;

public class TecnicoService {
    final TecnicoRepository repository;
    Dados dados;

    // Construtor:
    public TecnicoService(Dados d){
        repository = new TecnicoRepository(d);
        dados = d;
    }

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

        // Verifica dados:
        if(newTecnico.getNome().trim().isEmpty() || newTecnico.getMatricula().trim().isEmpty() || 
                newTecnico.getSetor().trim().isEmpty() || newTecnico.getTelefone().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar técnicos com algum dado vazio!");
        }

        // Verificando uniquidade de 'matricula':
        Tecnico t = repository.readMatricula(newTecnico.getMatricula());
        if(t != null && t.getCodigo() != id){
            throw new RuntimeException("ERRO: já existe um técnico com essa matrícula!");
        }

        // Atualizando:
        newTecnico.setCodigo(id);
        return repository.update(newTecnico);
    }

    // Deletar:
    public void deletar(int id){
        // Verifica se encontrou um dado:
        Tecnico tecnico = repository.readId(id);
        if(tecnico == null){
            throw new RuntimeException("ERRO: nenhum técnico com esse ID encontrado!");
        }

        // Verifica se não possui nenhuma manutenção em aberto:
        ManutencaoRepository mRepository = new ManutencaoRepository(dados);
        List<Manutencao> manutencoes = mRepository.readTecnicoId(id);
        for(Manutencao m : manutencoes){
            if(m.getSituacao().equals("Finalizado")){
                throw new
            }
        }

        repository.delete(id);
    }
}
