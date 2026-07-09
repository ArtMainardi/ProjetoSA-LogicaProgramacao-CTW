package projetoSA.service;

import java.util.List;
import projetoSA.model.Equipamento;
import projetoSA.repository.EquipamentoRepository;

public class EquipamentoService {
    private EquipamentoRepository repository;

    // Construtor:
    public EquipamentoService(Dados d)

    // Adicionar:
    public Equipamento adicionar(Equipamento newEquipamento){
        // Verifica dados:
        String status = newEquipamento.getStatus();
        if(newEquipamento.getNome().trim().isEmpty() || newEquipamento.getCategoria().trim().isEmpty() || newEquipamento.getFabricante().trim().isEmpty() || 
                newEquipamento.getModelo().trim().isEmpty() || newEquipamento.getSetorInstalado().trim().isEmpty() || 
                newEquipamento.getDataInstalacao().trim().isEmpty() || newEquipamento.getStatus().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar equipamentos com algum dado vazio!");
        }
        if(!status.equals("Operando") && !status.equals("Em manutenção") && !status.equals("Inativo")){
            throw new RuntimeException("ERRO: valor de 'status' inválido!");
        }

        // Cria:
        Equipamento equipamento = repository.create(newEquipamento);
        return equipamento;
    }

    // Listar:
    public List<Equipamento> listar(){
        List<Equipamento> equipamentos = repository.read();
        if(equipamentos.isEmpty()){
            throw new RuntimeException("Nenhum equipamento salvo!");
        }
        return equipamentos;
    }

    // Buscar:
    public Equipamento buscarId(int id){
        Equipamento equipamento = repository.readId(id);
        if(equipamento == null){
            throw new RuntimeException("ERRO: equipamento com esse ID não encontrado!");
        }
        return equipamento;
    }

    // Atualizar:
    public Equipamento atualizar(Equipamento modifiedEquipamento, int id){
        // Verifica se encontrou o equipamento com esse id:
        if(repository.readId(id) == null){
            throw new RuntimeException("ERRO: equipamento com esse ID não encontrado!");
        }

        // Verifica dados:
        String status = modifiedEquipamento.getStatus();
        if(modifiedEquipamento.getNome().trim().isEmpty() || modifiedEquipamento.getCategoria().trim().isEmpty() || modifiedEquipamento.getFabricante().trim().isEmpty() || 
                modifiedEquipamento.getModelo().trim().isEmpty() || modifiedEquipamento.getSetorInstalado().trim().isEmpty() || 
                modifiedEquipamento.getDataInstalacao().trim().isEmpty() || modifiedEquipamento.getStatus().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar equipamentos com algum dado vazio!");
        }
        if(!status.equals("Operando") && !status.equals("Em manutenção") && !status.equals("Inativo")){
            throw new RuntimeException("ERRO: valor de 'status' inválido!");
        }

        // Atualiza:
        modifiedEquipamento.setCodigo(id);
        return repository.update(modifiedEquipamento);
    }

    // Deletar:
    public void deletar(int id){
        // Verifica se encontrou o equipamento com esse id:
        Equipamento equipamento = repository.readId(id);
        if(equipamento == null){
            throw new RuntimeException("ERRO: equipamento com esse ID não encontrado!");
        }

        // Verifica se possui uma manutenção em aberto:
        if(equipamento.getStatus().equals("Em manutenção")){
            throw new RuntimeException("ERRO: esse equipamento não pode ser deletado; possui uma manutenção em aberto!");
        }

        repository.delete(id);
    }
}
