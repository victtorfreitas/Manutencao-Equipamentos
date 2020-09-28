package br.com.projuris.api.v1.cliente.assembler;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteAssembler implements AssamblerDefault<Cliente, ClienteCompletoResponse> {

    private final ModelMapper modelMapper;
    private final TelefoneAssembler telefoneAssembler;

    public ClienteAssembler(ModelMapper modelMapper, TelefoneAssembler telefoneAssembler) {
        this.modelMapper = modelMapper;
        this.telefoneAssembler = telefoneAssembler;
    }

    @Override
    public ClienteCompletoResponse toModel(Cliente cliente) {
        var clienteCompletoResponse = modelMapper.map(cliente, ClienteCompletoResponse.class);
        if (cliente.temTelefones()) {
            var telefones = telefoneAssembler.toListModel(cliente.getTelefones());
            clienteCompletoResponse.setTelefones(telefones);
        }

        return clienteCompletoResponse;
    }

    @Override
    public List<ClienteCompletoResponse> toListModel(List<Cliente> clientes) {
        return clientes.stream().map(this::toModel).collect(Collectors.toList());
    }
}
