package projetoSA.service;

import projetoSA.model.Manutencao;
import projetoSA.repository.EquipamentoRepository;
import projetoSA.repository.ManutencaoRepository;

public class ManutencaoService {
    ManutencaoRepository repository = new ManutencaoRepository();

    // Salvar:
    public Manutencao salvar(Manutencao objeto, EquipamentoRepository equipamentoRepository, Tecni){

        if()
        return repository.create(objeto);
    }
}
