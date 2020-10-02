package br.com.projuris.api.v1.cliente.assembler;

import br.com.projuris.api.v1.cliente.model.response.EnderecoCompletoResponse;
import br.com.projuris.domain.endereco.Endereco;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoAssembler implements AssamblerDefault<Endereco, EnderecoCompletoResponse> {
    private final ModelMapper modelMapper;

    public EnderecoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EnderecoCompletoResponse toModel(Endereco endereco) {
        return modelMapper.map(endereco, EnderecoCompletoResponse.class);
    }

    @Override
    public List<EnderecoCompletoResponse> toListModel(List<Endereco> enderecos) {
        if (temEnderecos(enderecos)) {
            return enderecos.stream().map(this::toModel).collect(Collectors.toList());
        }
        return null;
    }

    private boolean temEnderecos(List<Endereco> enderecos) {
        return enderecos != null;
    }
}
