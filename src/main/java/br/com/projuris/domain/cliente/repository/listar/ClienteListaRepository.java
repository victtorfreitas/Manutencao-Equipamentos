package br.com.projuris.domain.cliente.repository.listar;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.interfaces.RepositoryDefault;

public interface ClienteListaRepository extends RepositoryDefault<Cliente>, ClienteListaRepositoryCustom {
}

