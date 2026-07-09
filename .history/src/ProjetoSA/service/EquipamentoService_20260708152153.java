package projetoSA.service;

import java.util.List;
import projetoSA.model.Equipamento;
import projetoSA.repository.EquipamentoRepository;

public class EquipamentoService {
    private EquipamentoRepository repository = new EquipamentoRepository();

    // Adicionar:
    public Equipamento adicionar(Equipamento newEquipamento){
        String status = newEquipamento.getStatus();
        
        if(newEquipamento.getNome().trim().isEmpty() || newEquipamento.getCategoria().trim().isEmpty() || newEquipamento.getFabricante().trim().isEmpty() || 
                newEquipamento.getModelo().trim().isEmpty() || newEquipamento.getSetorInstalado().trim().isEmpty() || 
                newEquipamento.getDataInstalacao().trim().isEmpty() || newEquipamento.getStatus().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar equipamentos com algum dado vazio!");
        }
        if(!status.equals("Operando") && !status.equals("Operando") && !status.equals("Operando")){
            throw new RuntimeException("ERRO: valor de 'status' inválido!");
        }
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
        Equipamento = repository.readId(id);
        
    }
}
