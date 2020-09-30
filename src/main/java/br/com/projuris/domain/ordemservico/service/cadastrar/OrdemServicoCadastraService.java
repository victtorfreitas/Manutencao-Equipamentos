package br.com.projuris.domain.ordemservico.service.cadastrar;

import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoCadastrarRequest;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface OrdemServicoCadastraService extends ServiceDefault<OrdemServico> {
    OrdemServicoResumidoResponse cadastrar(OrdemServicoCadastrarRequest ordemServico);
}
