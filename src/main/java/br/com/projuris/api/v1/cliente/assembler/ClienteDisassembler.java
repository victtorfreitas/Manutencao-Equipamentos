package br.com.projuris.api.v1.cliente.assembler;

import br.com.projuris.api.v1.cliente.model.request.ClienteCadastrarRequest;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.interfaces.DissamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteDisassembler implements DissamblerDefault<Cliente, ClienteCadastrarRequest> {

    private final ModelMapper modelMapper;

    public ClienteDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Cliente toDomainObject(ClienteCadastrarRequest clienteCadastrarRequest) {
        Cliente cliente = modelMapper.map(clienteCadastrarRequest, Cliente.class);
        cliente.getTelefones().forEach(t -> t.setCliente(cliente));
        return cliente;
    }

    @Override
    public void copyToDomainObject(ClienteCadastrarRequest clienteCadastrarRequest, Cliente cliente) {
        modelMapper.map(clienteCadastrarRequest, cliente);
    }
}
