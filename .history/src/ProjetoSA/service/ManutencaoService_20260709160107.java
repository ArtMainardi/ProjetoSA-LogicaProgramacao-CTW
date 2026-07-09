package projetoSA.service;

import projetoSA.model.Manutencao;
import projetoSA.repository.ManutencaoRepository;

public class ManutencaoService {
    ManutencaoRepository repository = new ManutencaoRepository();

    // Salvar:
    public Manutencao salvar(Manutencao objeto){
        // <----  Fazer verificação da integridade do 'equipamento' aqui 
        // <----  Fazer verificação da integridade do 'tecnico' aqui 

        // Verificando integridade dos dados:
        if(objeto.getDataAbertura().trim().isEmpty() || objeto.getDataEncerramento().trim().isEmpty() 
                || objeto.getTipoManutencao().trim().isEmpty() || objeto.getSituacao().trim().isEmpty()){
            throw new RuntimeException("ERRO: não é permitido cadastrar manutenções com algum dado vazio!");
        }

        // Verificar valores de 'tipoMovimentacao':
        if(!objeto.getTipoManutencao().equals("Preventiva") && !objeto.getTipoManutencao().equals("Preventiva")){
            throw new RuntimeException("");
        }

        return repository.create(objeto);
    }
}
