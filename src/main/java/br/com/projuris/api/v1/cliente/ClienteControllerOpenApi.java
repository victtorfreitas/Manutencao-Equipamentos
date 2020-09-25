package br.com.projuris.api.v1.cliente;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import io.swagger.annotations.Api;

import java.util.List;

@Api(tags = "Clientes")
public interface ClienteControllerOpenApi {
    List<ClienteCompletoResponse> listar();
}
