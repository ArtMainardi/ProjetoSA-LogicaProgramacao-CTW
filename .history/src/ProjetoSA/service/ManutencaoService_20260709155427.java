package projetoSA.service;

import projetoSA.model.Manutencao;
import projetoSA.repository.EquipamentoRepository;
import projetoSA.repository.ManutencaoRepository;
import projetoSA.repository.TecnicoRepository;

public class ManutencaoService {
    ManutencaoRepository repository = new ManutencaoRepository();

    // Salvar:
    public Manutencao salvar(Manutencao objeto, EquipamentoRepository equipamentoRepository, TecnicoRepository tecnicoRepository){

        if()
        return repository.create(objeto);
    }
}
