package br.com.projuris.domain.cliente.service.hand;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

import java.util.List;

public interface ClienteListaService extends ServiceDefault<Cliente> {
    List<ClienteCompletoResponse> findClienteCompletoResponseAll();
}
