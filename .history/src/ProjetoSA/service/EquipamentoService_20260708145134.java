package projetoSA.service;

import java.util.List;
import projetoSA.model.Equipamento;
import projetoSA.repository.EquipamentoRepository;

public class EquipamentoService {
    private EquipamentoRepository service = new EquipamentoRepository();

    // Adicionar:
    public Equipamento adicionar(Equipamento newEquipamento){
        String status = newEquipamento.getStatus();
        try {
            if(newEquipamento.getNome().trim().isEmpty() || newEquipamento.getCategoria().trim().isEmpty() || newEquipamento.getFabricante().trim().isEmpty() || 
                    newEquipamento.getModelo().trim().isEmpty() || newEquipamento.getSetorInstalado().trim().isEmpty() || 
                    newEquipamento.getDataInstalacao().trim().isEmpty() || newEquipamento.getStatus().trim().isEmpty()){
                throw new Exception("ERRO: não é permitido cadastrar equipamentos com algum dado vazio!");
            }
            if(!status.equals("Operando") && !status.equals("Operando") && !status.equals("Operando")){
                throw new Exception("ERRO: valor de 'status' inválido!");
            }
            Equipamento equipamento = service.create(newEquipamento);
            return equipamento;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Listar:
    public List<Equipamento> listar(){
        return service.read();
    }
}
