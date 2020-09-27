package br.com.projuris.domain.cliente.service;

import br.com.projuris.api.v1.cliente.assembler.ClienteAssembler;
import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.cliente.repository.listar.ClienteListaRepository;
import br.com.projuris.domain.cliente.service.hand.ClienteListaService;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteListaServiceImpl extends ServiceAbsDefault<Cliente> implements ClienteListaService {

    private final ClienteListaRepository clienteListaRepository;
    private final ClienteAssembler clienteAssembler;


    public ClienteListaServiceImpl(ClienteListaRepository clienteListaRepository,
                                   ClienteAssembler clienteAssembler) {

        super(clienteListaRepository);
        this.clienteListaRepository = clienteListaRepository;
        this.clienteAssembler = clienteAssembler;
    }

    @Override
    public List<ClienteCompletoResponse> buscaTodos() {
        return clienteListaRepository.findAll()
                .stream()
                .map(clienteAssembler::toModel)
                .collect(Collectors.toList());
    }
}
