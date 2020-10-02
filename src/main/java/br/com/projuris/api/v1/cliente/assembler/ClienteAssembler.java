package br.com.projuris.api.v1.cliente.assembler;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.api.v1.cliente.model.response.EnderecoCompletoResponse;
import br.com.projuris.api.v1.cliente.model.response.TelefoneCompletoResponse;
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
    private final EnderecoAssembler enderecoAssembler;

    public ClienteAssembler(ModelMapper modelMapper, TelefoneAssembler telefoneAssembler,
                            EnderecoAssembler enderecoAssembler) {
        this.modelMapper = modelMapper;
        this.telefoneAssembler = telefoneAssembler;
        this.enderecoAssembler = enderecoAssembler;
    }

    @Override
    public ClienteCompletoResponse toModel(Cliente cliente) {
        var clienteCompletoResponse = modelMapper.map(cliente, ClienteCompletoResponse.class);
        preencheDadosAdicionais(cliente, clienteCompletoResponse);
        return clienteCompletoResponse;
    }

    private void preencheDadosAdicionais(Cliente cliente, ClienteCompletoResponse clienteCompletoResponse) {
        clienteCompletoResponse.setTelefones(buscaTelefones(cliente));
        clienteCompletoResponse.setEnderecos(buscaEnderecos(cliente));
    }

    private List<EnderecoCompletoResponse> buscaEnderecos(Cliente cliente) {
        return enderecoAssembler.toListModel(cliente.getEnderecos());
    }

    private List<TelefoneCompletoResponse> buscaTelefones(Cliente cliente) {
        return telefoneAssembler.toListModel(cliente.getTelefones());
    }

    @Override
    public List<ClienteCompletoResponse> toListModel(List<Cliente> clientes) {
        return clientes.stream().map(this::toModel).collect(Collectors.toList());
    }
}
