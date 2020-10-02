package br.com.projuris.api.v1.problema.assembler;

import br.com.projuris.api.v1.problema.model.request.ProblemaResumidoRequest;
import br.com.projuris.domain.problema.Problema;
import br.com.projuris.infrastructure.interfaces.DissamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProblemaCadastrarDisassembler implements DissamblerDefault<Problema, ProblemaResumidoRequest> {

    private final ModelMapper modelMapper;

    public ProblemaCadastrarDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Problema toDomainObject(ProblemaResumidoRequest problema) {
        return modelMapper.map(problema, Problema.class);
    }

    @Override
    public void copyToDomainObject(ProblemaResumidoRequest problemaCadastrar, Problema problema) {
        modelMapper.map(problemaCadastrar, problema);
    }

}
