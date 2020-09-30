package br.com.projuris.domain.cliente.service.validar;

import br.com.projuris.api.v1.cliente.model.request.ClienteSimplesRequest;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.cliente.repository.listar.ClienteListaRepository;
import br.com.projuris.domain.exception.ClienteNaoEncontradaException;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteValidaServiceImpl extends ServiceAbsDefault<Cliente> implements ClienteValidaService {

    private final ClienteListaRepository clienteListaRepository;

    @Autowired
    public ClienteValidaServiceImpl(ClienteListaRepository clienteListaRepository) {
        super(clienteListaRepository);
        this.clienteListaRepository = clienteListaRepository;
    }

    @Override
    public void isCliente(ClienteSimplesRequest cliente) {
        clienteListaRepository
                .findById(cliente.getId())
                .orElseThrow(() -> new ClienteNaoEncontradaException(cliente.getId()));
    }
}
