package br.com.projuris.api.v1.cliente.assembler;

import br.com.projuris.api.v1.cliente.model.request.TelefoneCadastrarRequest;
import br.com.projuris.api.v1.cliente.model.response.TelefoneCompletoResponse;
import br.com.projuris.domain.telefone.Telefone;
import br.com.projuris.infrastructure.interfaces.DissamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelefoneDisassembler implements DissamblerDefault<Telefone, TelefoneCompletoResponse> {

    private final ModelMapper modelMapper;

    public TelefoneDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Telefone toDomainObject(TelefoneCompletoResponse telefoneCompletoResponse) {
        return modelMapper.map(telefoneCompletoResponse, Telefone.class);
    }

    public Telefone toDomainObject(TelefoneCadastrarRequest telefoneCadastrarRequest) {
        return modelMapper.map(telefoneCadastrarRequest, Telefone.class);
    }

    public List<Telefone> toDomainList(List<TelefoneCadastrarRequest> telefones) {
        return telefones.stream().map(this::toDomainObject).collect(Collectors.toList());
    }

    @Override
    public void copyToDomainObject(TelefoneCompletoResponse telefoneCompletoResponse, Telefone telefone) {
        modelMapper.map(telefoneCompletoResponse, telefone);
    }
}
