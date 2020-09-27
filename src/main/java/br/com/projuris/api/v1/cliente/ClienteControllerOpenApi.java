package br.com.projuris.api.v1.cliente;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = "Clientes")
public interface ClienteControllerOpenApi {

    @ApiOperation("Lisa todos os clientes ativos")
    List<ClienteCompletoResponse> listar();
}
