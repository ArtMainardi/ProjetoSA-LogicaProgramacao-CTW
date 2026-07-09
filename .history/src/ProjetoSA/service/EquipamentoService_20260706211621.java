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
            if(newEquipamento.getNome().trim().isEmpty()){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
