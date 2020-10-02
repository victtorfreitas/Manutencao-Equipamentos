package br.com.projuris.api.v1.problema.assembler;

import br.com.projuris.api.v1.problema.model.response.ProblemaResumidoResponse;
import br.com.projuris.domain.problema.Problema;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProblemaCadastraAssembler implements AssamblerDefault<Problema, ProblemaResumidoResponse> {
    private final ModelMapper modelMapper;

    public ProblemaCadastraAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProblemaResumidoResponse toModel(Problema Problema) {
        return modelMapper.map(Problema, ProblemaResumidoResponse.class);
    }

    @Override
    public List<ProblemaResumidoResponse> toListModel(List<Problema> Problema) {
        return Problema.stream().map(this::toModel).collect(Collectors.toList());
    }
}
