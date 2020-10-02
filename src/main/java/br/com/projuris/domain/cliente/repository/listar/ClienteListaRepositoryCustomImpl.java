package br.com.projuris.domain.cliente.repository.listar;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.abstracts.QueryDslAbsSuport;


public class ClienteListaRepositoryCustomImpl extends QueryDslAbsSuport<Cliente> implements ClienteListaRepositoryCustom {
    public ClienteListaRepositoryCustomImpl() {
        super(Cliente.class);
    }

}
