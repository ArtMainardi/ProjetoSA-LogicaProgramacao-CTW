package projetoSA.service;

import java.util.List;
import projetoSA.model.Manutencao;
import projetoSA.repository.ManutencaoRepository;

public class ManutencaoService {
    ManutencaoRepository repository = new ManutencaoRepository();

    // Salvar:
    public Manutencao salvar(Manutencao objeto, EquipamentoService eService, TecnicoService tService){
        // <----  Fazer verificação da integridade do 'tecnico' aqui 
        // <----  Fazer verificação da integridade do 'equipamento' aqui 
        // <----  Fazer verificação de disponibilidade do 'equipamento' aqui 

        // Verificando integridade dos dados:
        if(objeto.getDataAbertura().trim().isEmpty() || objeto.getDataEncerramento().trim().isEmpty() 
                || objeto.getTipoManutencao().trim().isEmpty() || objeto.getSituacao().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar manutenções com algum dado vazio!");
        }

        // Verificar valores de 'tipoMovimentacao':
        if(!objeto.getTipoManutencao().equals("Preventiva") && !objeto.getTipoManutencao().equals("Preventiva")){
            throw new RuntimeException("ERRO: valor de 'tipo de movimentação' inválido!");
        }

        // Verificar valores de 'situacao':
        if(!objeto.getSituacao().equals("Aberta") && !objeto.getSituacao().equals("Em andamento") && !objeto.getSituacao().equals("Finalizada")){
            throw new RuntimeException("ERRO: valor de 'situacao' inválido!");
        }
        
        // <----  Fazer atualização de status de 'equipamento' aqui
        return repository.create(objeto);
    }

    // Listar:
    public List<Manutencao> listar(){
        List<Manutencao> manutencoes = repository.read();

        // Verifica se encontrou um dado:
        if(manutencoes.isEmpty()){
            throw new RuntimeException("Nenhuma manutenção salva!");
        }
        return manutencoes;
    }

    // Buscar (ID):
    public Manutencao buscarId(int id){
        Manutencao objeto = repository.readId(id);

        // Verifica se encontrou o dado:
        if(objeto == null){
            throw new RuntimeException("ERRO: nenhuma manutenção encontrada com esse ID!");
        }
        return objeto;
    }

    // Atualizar:
    public Manutencao atualizar(Manutencao modifiedManutencao, int id){
        // Verifica se encontrou o dado:
        Manutencao objeto = repository.readId(id);
        if(objeto == null){
            throw new RuntimeException("ERRO: nenhuma manutenção encontrada com esse ID!");
        }

        // <----  Fazer verificação da integridade do 'tecnico' aqui 
        // <----  Fazer verificação da integridade do 'equipamento' aqui 
        // <----  Fazer verificação de disponibilidade do 'equipamento' aqui 

        // Verificando integridade dos dados:
        if(objeto.getDataAbertura().trim().isEmpty() || objeto.getDataEncerramento().trim().isEmpty() 
                || objeto.getTipoManutencao().trim().isEmpty() || objeto.getSituacao().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar manutenções com algum dado vazio!");
        }

        // Verificar valores de 'tipoMovimentacao':
        if(!objeto.getTipoManutencao().equals("Preventiva") && !objeto.getTipoManutencao().equals("Preventiva")){
            throw new RuntimeException("ERRO: valor de 'tipo de movimentação' inválido!");
        }

        // Verificar valores de 'situacao':
        if(!objeto.getSituacao().equals("Aberta") && !objeto.getSituacao().equals("Em andamento") && !objeto.getSituacao().equals("Finalizada")){
            throw new RuntimeException("ERRO: valor de 'situacao' inválido!");
        }
        
        // <----  Fazer atualização de status dos equipamentos (antigo e novo, se forem diferentes) aqui
        
        modifiedManutencao.setCodigo(id);
        return repository.update(modifiedManutencao);
    }

    // Modificar status:
    public Manutencao modificarStatus(int id, String status){
        // Verifica se encontrou o dado:
        Manutencao objeto = repository.readId(id);
        if(objeto == null){
            throw new RuntimeException("ERRO: nenhuma manutenção encontrada com esse ID!");
        }

        // Compara estado atual:
        if(objeto.getSituacao().equals(status)){
            throw new RuntimeException("ERRO: a manutenção com esse ID já possui o status informado!");
        }

        // Verifica valores de 'situacao':
        if(status.equals("Aberta")){
            if(objeto.getSituacao().equals("Finalizada")){
                // <----  Fazer verificação de disponibilidade do 'equipamento' aqui 
                // <----  Fazer atualização de status do equipamento aqui
            }
        } else if(status.equals("Finalizada")){
            // <----  Fazer atualização de status do equipamento aqui
        } else if(!status.equals("Em andamento")){
            throw new RuntimeException("ERRO: valor de 'situacao' inválido!");
        }

        // Faz a atualização:
        objeto.setSituacao(status);
        return repository.update(objeto);
    }

    // Deletar:
    public void deletar(int id){
        // Verifica se encontrou o dado:
        Manutencao objeto = repository.readId(id);
        if(objeto == null){
            throw new RuntimeException("ERRO: nenhuma manutenção encontrada com esse ID!");
        }

        // <----  Fazer atualização de status de 'equipamento' aqui
        repository.delete(id);
    }
}
