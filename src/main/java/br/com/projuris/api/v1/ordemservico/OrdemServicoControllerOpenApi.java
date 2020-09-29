package br.com.projuris.api.v1.ordemservico;

import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = "OrdemServicos")
public interface OrdemServicoControllerOpenApi {

    @ApiOperation("Lisa todos as Ordem de Serviços ativas")
    List<OrdemServicoCompletoResponse> listar();
}
