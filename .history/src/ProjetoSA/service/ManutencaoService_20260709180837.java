package projetoSA.service;

import java.util.List;
import projetoSA.model.Equipamento;
import projetoSA.model.Manutencao;
import projetoSA.repository.ManutencaoRepository;

public class ManutencaoService {
    ManutencaoRepository repository = new ManutencaoRepository();

    // Salvar:
    public Manutencao salvar(Manutencao objeto, EquipamentoService eService, TecnicoService tService){
        // Verificação da integridade do 'tecnico'
        tService.buscarId(objeto.getTecnico().getCodigo());

        // Verifica integridade do 'equipamento' aqui:
        Equipamento e = eService.buscarId(objeto.getEquipamento().getCodigo());
        // Verifica disponibilidade do 'equipamento':
        if(e.getStatus().equals("Em manutenção")){
            throw new RuntimeException("ERRO: o equipamento informado já possui uma manutenção em aberto!");
        }

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
        
        // Atualiza status de 'equipamento':
        e.setStatus("Em manutenção");
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
    public Manutencao atualizar(Manutencao modifiedManutencao, int id, EquipamentoService eService, TecnicoService tService){
        // Verifica se encontrou o dado:
        Manutencao objeto = repository.readId(id);
        if(objeto == null){
            throw new RuntimeException("ERRO: nenhuma manutenção encontrada com esse ID!");
        }

        // Verificação da integridade do novo 'tecnico'
        tService.buscarId(modifiedManutencao.getTecnico().getCodigo());

        // Verifica integridade do novo 'equipamento':
        Equipamento e = eService.buscarId(modifiedManutencao.getEquipamento().getCodigo());
        // Verifica disponibilidade do novo 'equipamento':
        if(e.getStatus().equals("Em manutenção")){
            throw new RuntimeException("ERRO: o equipamento informado já possui uma manutenção em aberto!");
        }

        // Verificando integridade dos novos dados:
        if(modifiedManutencao.getDataAbertura().trim().isEmpty() || objeto.getDataEncerramento().trim().isEmpty() 
                || modifiedManutencao.getTipoManutencao().trim().isEmpty() || objeto.getSituacao().trim().isEmpty()){
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
        
        // Atualiza status dos equipamentos (antigo e novo, se forem diferentes):
        if(objeto.getEquipamento() != e){

        }
        
        modifiedManutencao.setCodigo(id);
        return repository.update(modifiedManutencao);
    }

    // Modificar status:
    public Manutencao modificarStatus(int id, String status, EquipamentoService eService){
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
        Equipamento e = eService.buscarId(objeto.getEquipamento().getCodigo());
        if(status.equals("Aberta")){
            if(objeto.getSituacao().equals("Finalizada")){
                // Verifica disponibilidade do 'equipamento':
                if(e.getStatus().equals("Em manutenção")){
                    throw new RuntimeException("ERRO: o equipamento informado já possui uma manutenção em aberto!");
                }
                // Atualiza status de 'equipamento':
                e.setStatus("Em manutenção");
            }
        } else if(status.equals("Finalizada")){
            // Atualiza status de 'equipamento':
            e.setStatus("Operando");
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
