package br.com.projuris.api.v1.ordemservico.assembler;

import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoCadastrarRequest;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.infrastructure.interfaces.DissamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdemServicoCadastrarDisassembler implements DissamblerDefault<OrdemServico, OrdemServicoCadastrarRequest> {

    private final ModelMapper modelMapper;

    public OrdemServicoCadastrarDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrdemServico toDomainObject(OrdemServicoCadastrarRequest ordemServicoSimples) {
        return modelMapper.map(ordemServicoSimples, OrdemServico.class);
    }

    @Override
    public void copyToDomainObject(OrdemServicoCadastrarRequest ordemServicoSimples, OrdemServico ordemServico) {
        modelMapper.map(ordemServicoSimples, ordemServico);
    }

    public List<OrdemServico> toDomainList(List<OrdemServicoCadastrarRequest> ordemServicoSimpless) {
        return ordemServicoSimpless.stream().map(this::toDomainObject).collect(Collectors.toList());
    }

}
