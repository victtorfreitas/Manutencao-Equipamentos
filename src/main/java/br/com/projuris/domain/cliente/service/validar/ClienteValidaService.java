package br.com.projuris.domain.cliente.service.validar;

import br.com.projuris.api.v1.cliente.model.request.ClienteSimplesRequest;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface ClienteValidaService extends ServiceDefault<Cliente> {
    void isCliente(ClienteSimplesRequest cliente);
}
