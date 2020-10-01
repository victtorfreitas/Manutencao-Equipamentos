package br.com.projuris.domain.ordemservico.service.listar;

import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

import java.util.List;

public interface OrdemServicoListaService extends ServiceDefault<OrdemServico> {
    List<OrdemServicoCompletoResponse> buscaTodos();

    List<OrdemServicoResumidoResponse> listaPendentesPorResponsavel(Long idResponsavel);
}
