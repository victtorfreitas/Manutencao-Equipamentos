package br.com.projuris.domain.resultado.service.cadastrar;

import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoSimplesRequest;
import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import br.com.projuris.domain.resultado.Resultado;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface ResultadoCadastraService extends ServiceDefault<Resultado> {
    ResultadoCompletoResponse iniciaAtendimento(OrdemServicoSimplesRequest ordemServico);

    ResultadoCompletoResponse atualiza(String descricao, Long ordemServicoId);
}

