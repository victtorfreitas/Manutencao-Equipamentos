package br.com.projuris.domain.telefone.repository.listar;

import br.com.projuris.api.v1.cliente.model.response.TelefoneCompletoResponse;
import br.com.projuris.domain.telefone.Telefone;
import br.com.projuris.infrastructure.interfaces.RepositoryDefault;

import java.util.List;

public interface TelefoneListaRepository extends RepositoryDefault<Telefone>, TelefoneListaRepositoryCustom {
    List<TelefoneCompletoResponse> findAllByCliente_Id(Long id);
}

