package br.com.projuris.domain.cliente.service.listar;

import br.com.projuris.api.v1.cliente.assembler.ClienteAssembler;
import br.com.projuris.api.v1.cliente.assembler.ClienteDisassembler;
import br.com.projuris.api.v1.cliente.model.request.ClienteCadastrarRequest;
import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.cliente.repository.listar.ClienteListaRepository;
import br.com.projuris.domain.telefone.service.cadastrar.TelefoneCadastrarService;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteListaServiceImpl extends ServiceAbsDefault<Cliente> implements ClienteListaService {

    private final ClienteListaRepository clienteListaRepository;
    private final ClienteAssembler clienteAssembler;
    private final ClienteDisassembler clienteDisassembler;
    private final TelefoneCadastrarService telefoneCadastrarService;


    public ClienteListaServiceImpl(ClienteListaRepository clienteListaRepository,
                                   ClienteAssembler clienteAssembler,
                                   ClienteDisassembler clienteDisassembler,
                                   TelefoneCadastrarService telefoneCadastrarService) {

        super(clienteListaRepository);
        this.clienteListaRepository = clienteListaRepository;
        this.clienteAssembler = clienteAssembler;
        this.clienteDisassembler = clienteDisassembler;
        this.telefoneCadastrarService = telefoneCadastrarService;
    }

    @Override
    public List<ClienteCompletoResponse> buscaTodos() {
        return clienteListaRepository.findAll()
                .stream()
                .map(clienteAssembler::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteCompletoResponse cadastrar(ClienteCadastrarRequest clienteRequest) {
        Cliente clienteBD = clienteListaRepository.save(clienteDisassembler.toDomainObject(clienteRequest));
        return clienteAssembler.toModel(clienteBD);
    }
}
