package projetoSA.service;

import projetoSA.model.Equipamento;
import projetoSA.repository.EquipamentoRepository;

public class EquipamentoService {
    private EquipamentoRepository service;
    
    // Construtor que recebe o service criado na main:
    public EquipamentoService(EquipamentoRepository service) {
        this.service = service;
    }

    // Adicionar:
    public Equipamento adicionar(Equipamento newEquipamento){
        try {
            if(newEquipamento.getNome().trim().isEmpty() || newEquipamento.getCategoria().trim().isEmpty() || newEquipamento.getFabricante().trim().isEmpty() || 
                newEquipamento.getModelo().trim().isEmpty() || newEquipamento.getSetorInstalado().trim().isEmpty() || 
                newEquipamento.getDataInstalacao().trim().isEmpty() || status.trim().isEmpty()){
                throw new Exception("ERRO: não é permitido cadastrar equipamentos com algum dado vazio!");
            }
            Equipamento equipamento = service.create(newEquipamento);
            return equipamento;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
