package br.com.projuris.api.v1.cliente.assembler;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.api.v1.cliente.model.response.TelefoneCompletoResponse;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ClienteAssembler implements AssamblerDefault<Cliente, ClienteCompletoResponse> {

    private final ModelMapper modelMapper;

    public ClienteAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClienteCompletoResponse toModel(Cliente cliente) {
        var telefones = cliente.getTelefones()
                .stream()
                .map(t -> modelMapper.map(t, TelefoneCompletoResponse.class))
                .collect(Collectors.toList());

        var clienteCompletoResponse = modelMapper.map(cliente, ClienteCompletoResponse.class);
        clienteCompletoResponse.setTelefones(telefones);
        return clienteCompletoResponse;
    }
}
