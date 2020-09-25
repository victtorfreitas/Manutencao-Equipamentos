package br.com.projuris.domain.cliente.repository;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.cliente.repository.hand.ClienteListaRepositoryCustom;
import br.com.projuris.infrastructure.abstracts.QueryDslAbsSuport;

public class ClienteListaRepositoryImpl extends QueryDslAbsSuport<Cliente> implements ClienteListaRepositoryCustom {
    public ClienteListaRepositoryImpl() {
        super(Cliente.class);
    }
}
