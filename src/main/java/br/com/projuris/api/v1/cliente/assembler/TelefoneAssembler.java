package br.com.projuris.api.v1.cliente.assembler;

import br.com.projuris.api.v1.cliente.model.response.TelefoneCompletoResponse;
import br.com.projuris.domain.telefone.Telefone;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelefoneAssembler implements AssamblerDefault<Telefone, TelefoneCompletoResponse> {
    private final ModelMapper modelMapper;

    public TelefoneAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TelefoneCompletoResponse toModel(Telefone telefone) {
        return modelMapper.map(telefone, TelefoneCompletoResponse.class);
    }

    public List<TelefoneCompletoResponse> toListModel(List<Telefone> telefones) {
        if (temTelefones(telefones)) {
            return telefones.stream().map(this::toModel).collect(Collectors.toList());
        }
        return null;
    }

    private boolean temTelefones(List<Telefone> telefones) {
        return telefones != null;
    }
}
