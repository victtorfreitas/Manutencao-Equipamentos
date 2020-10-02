package br.com.projuris.domain.problema.service.cadastrar;

import br.com.projuris.api.v1.problema.assembler.ProblemaCadastrarDisassembler;
import br.com.projuris.api.v1.problema.model.request.ProblemaResumidoRequest;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.problema.Problema;
import br.com.projuris.domain.problema.repository.cadastrar.ProblemaCadastraRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProblemaCadastraServiceImpl extends ServiceAbsDefault<Problema> implements ProblemaCadastraService {

    private final ProblemaCadastraRepository problemaCadastraRepository;
    private final ProblemaCadastrarDisassembler problemaCadastrarDisassembler;

    @Autowired
    public ProblemaCadastraServiceImpl(ProblemaCadastraRepository problemaCadastraRepository,
                                       ProblemaCadastrarDisassembler problemaCadastrarDisassembler) {
        super(problemaCadastraRepository);
        this.problemaCadastraRepository = problemaCadastraRepository;
        this.problemaCadastrarDisassembler = problemaCadastrarDisassembler;
    }

    @Override
    public void cadastrar(List<ProblemaResumidoRequest> problemasRequest, Long id) {
        var problemas = problemasRequest.stream()
                .map(problemaCadastrarDisassembler::toDomainObject)
                .peek(problema -> problema.setEquipamento(new Equipamento(id)))
                .collect(Collectors.toList());
        problemaCadastraRepository.saveAll(problemas);
    }
}
