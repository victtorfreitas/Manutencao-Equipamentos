package br.com.projuris.domain.ordemservico.service.validar;

import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoSimplesRequest;
import br.com.projuris.domain.exception.OrdemServicoNaoEncontradaException;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.repository.listar.OrdemServicoListaRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoValidaServiceImpl extends ServiceAbsDefault<OrdemServico> implements OrdemServicoValidaService {

    private final OrdemServicoListaRepository ordemServicoListaRepository;

    @Autowired
    public OrdemServicoValidaServiceImpl(OrdemServicoListaRepository ordemServicoListaRepository) {
        super(ordemServicoListaRepository);
        this.ordemServicoListaRepository = ordemServicoListaRepository;
    }

    @Override
    public void isOrdemServico(OrdemServicoSimplesRequest ordemServico) {
        ordemServicoListaRepository
                .findByIdAndStarted(ordemServico.getId())
                .orElseThrow(() -> getOsNaoEncontradaException(ordemServico));
    }

    private OrdemServicoNaoEncontradaException getOsNaoEncontradaException(OrdemServicoSimplesRequest ordemServico) {
        String textoPadrao = "Não existe uma ordem de serviço não inciada com o código ";
        return new OrdemServicoNaoEncontradaException(textoPadrao + ordemServico.getId());
    }
}
