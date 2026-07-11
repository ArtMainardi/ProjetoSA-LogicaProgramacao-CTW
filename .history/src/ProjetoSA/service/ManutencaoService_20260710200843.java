package projetoSA.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import projetoSA.model.Equipamento;
import projetoSA.model.Manutencao;
import projetoSA.repository.Dados;
import projetoSA.repository.ManutencaoRepository;

public class ManutencaoService {
    final ManutencaoRepository repository;
    final EquipamentoService eService;
    final TecnicoService tService;
    final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // Construtor:
    public ManutencaoService(Dados d){
        repository = new ManutencaoRepository(d);
        eService = new EquipamentoService(d);
        tService = new TecnicoService(d);
    }

    // Salvar:
    public Manutencao salvar(Manutencao objeto){
        // Verificação da integridade do 'tecnico'
        tService.buscarId(objeto.getTecnico().getCodigo());

        // Verifica integridade do 'equipamento' aqui:
        Equipamento e = eService.buscarId(objeto.getEquipamento().getCodigo());
        // Verifica disponibilidade do 'equipamento':
        if(e.getStatus().equals("Em manutencao")){
            throw new RuntimeException("ERRO: o equipamento informado já possui uma manutenção em aberto!");
        }
        LocalDate validacao = LocalDate.par
        // Verificando integridade dos dados:
        if(objeto.getDataAbertura().trim().isEmpty() || objeto.getDataEncerramento().trim().isEmpty() 
                || objeto.getTipoManutencao().trim().isEmpty() || objeto.getSituacao().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar manutenções com algum dado vazio!");
        }

        // Verificar valores de 'tipoMovimentacao':
        if(!objeto.getTipoManutencao().equals("Preventiva") && !objeto.getTipoManutencao().equals("Corretiva")){
            throw new RuntimeException("ERRO: valor de 'tipo de manutenção' inválido!");
        }

        // Verificar valores de 'situacao':
        if(!objeto.getSituacao().equals("Aberta") && !objeto.getSituacao().equals("Em andamento") && !objeto.getSituacao().equals("Finalizada")){
            throw new RuntimeException("ERRO: valor de 'situacao' inválido!");
        }
        
        // Atualiza status de 'equipamento':
        e.setStatus("Em manutencao");
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

        // Verificação da integridade do novo 'tecnico'
        tService.buscarId(modifiedManutencao.getTecnico().getCodigo());

        // Verifica integridade do novo 'equipamento':
        Equipamento e = eService.buscarId(modifiedManutencao.getEquipamento().getCodigo());
        // Verifica disponibilidade do novo 'equipamento':
        if(e.getStatus().equals("Em manutencao")){
            throw new RuntimeException("ERRO: o equipamento informado já possui uma manutenção em aberto!");
        }

        // Verificando integridade dos novos dados:
        if(modifiedManutencao.getDataAbertura().trim().isEmpty() || modifiedManutencao.getDataEncerramento().trim().isEmpty() 
                || modifiedManutencao.getTipoManutencao().trim().isEmpty() || modifiedManutencao.getSituacao().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar manutenções com algum dado vazio!");
        }

        // Verificar valores de 'tipoMovimentacao':
        if(!modifiedManutencao.getTipoManutencao().equals("Preventiva") && !modifiedManutencao.getTipoManutencao().equals("Corretiva")){
            throw new RuntimeException("ERRO: valor de 'tipo de manutenção' inválido!");
        }

        // Verificar valores de 'situacao':
        if(!modifiedManutencao.getSituacao().equals("Aberta") && !modifiedManutencao.getSituacao().equals("Em andamento") 
                && !modifiedManutencao.getSituacao().equals("Finalizada")){
            throw new RuntimeException("ERRO: valor de 'situacao' inválido!");
        }
        
        // Atualiza status dos equipamentos (antigo e novo, se forem diferentes):
        if(objeto.getEquipamento() != e){
            objeto.getEquipamento().setStatus("Operando");
            e.setStatus("Em manutencao");
        }
        
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
        Equipamento e = eService.buscarId(objeto.getEquipamento().getCodigo());
        if(!objeto.getSituacao().equals("Finalizada")){
            if(status.equals("Finalizada")){
                // Atualiza status de 'equipamento':
                e.setStatus("Operando");
                objeto.setDataEncerramento(LocalDate.now().format(formatador));
            } else if(!status.equals("Em andamento") && !status.equals("Aberta")){
                throw new RuntimeException("ERRO: valor de 'situacao' inválido!");
            }
        } else{
            throw new RuntimeException("ERRO: essa manutenção já foi finalizada!");
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

        // Atualiza status de 'equipamento':
        objeto.getEquipamento().setStatus("Operando");
        repository.delete(id);
    }
}
