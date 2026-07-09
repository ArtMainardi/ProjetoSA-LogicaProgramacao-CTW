package projetoSA.service;

import projetoSA.model.Manutencao;
import projetoSA.repository.ManutencaoRepository;

public class ManutencaoService {
    ManutencaoRepository repository = new ManutencaoRepository();

    // Salvar:
    public Manutencao salvar(Manutencao objeto){
        // <----  Fazer verificação da integridade do 'equipamento' aqui 
        // <----  Fazer verificação da integridade do 'tecnico' aqui 
        if(objeto.getDataAbertura().trim().isEmpty()){
            throw new RuntimeException("");
        }
        return repository.create(objeto);
    }
}
