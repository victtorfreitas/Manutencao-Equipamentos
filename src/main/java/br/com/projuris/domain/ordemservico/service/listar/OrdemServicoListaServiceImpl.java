package br.com.projuris.domain.ordemservico.service.listar;

import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.repository.listar.OrdemServicoListaRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoListaServiceImpl extends ServiceAbsDefault<OrdemServico> implements OrdemServicoListaService {

    private final OrdemServicoListaRepository ordemServicoListaRepository;

    @Autowired
    public OrdemServicoListaServiceImpl(OrdemServicoListaRepository ordemServicoListaRepository) {
        super(ordemServicoListaRepository);
        this.ordemServicoListaRepository = ordemServicoListaRepository;
    }

}
