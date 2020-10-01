package br.com.projuris.domain.ordemservico.service.validar;

import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoSimplesRequest;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface OrdemServicoValidaService extends ServiceDefault<OrdemServico> {
    void isOrdemServico(OrdemServicoSimplesRequest ordemServico);
}
