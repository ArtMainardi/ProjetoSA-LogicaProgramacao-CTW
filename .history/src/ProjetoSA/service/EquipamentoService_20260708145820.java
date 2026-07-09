package projetoSA.service;

import java.util.List;
import projetoSA.model.Equipamento;
import projetoSA.repository.EquipamentoRepository;

public class EquipamentoService {
    private EquipamentoRepository repository = new EquipamentoRepository();

    // Adicionar:
    public Equipamento adicionar(Equipamento newEquipamento){
        String status = newEquipamento.getStatus();
        try {
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Listar:
    public List<Equipamento> listar(){
        return repository.read();
    }
}
