package br.com.projuris.domain.ordemservico.service.listar;

import br.com.projuris.api.v1.ordemservico.assembler.OrdemServicoListarAssembler;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.repository.listar.OrdemServicoListaRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdemServicoListaServiceImpl extends ServiceAbsDefault<OrdemServico> implements OrdemServicoListaService {

    private final OrdemServicoListaRepository ordemServicoListaRepository;
    private final OrdemServicoListarAssembler ordemServicoListarAssembler;

    @Autowired
    public OrdemServicoListaServiceImpl(OrdemServicoListaRepository ordemServicoListaRepository,
                                        OrdemServicoListarAssembler ordemServicoListarAssembler) {
        super(ordemServicoListaRepository);
        this.ordemServicoListaRepository = ordemServicoListaRepository;
        this.ordemServicoListarAssembler = ordemServicoListarAssembler;
    }

    @Override
    public List<OrdemServicoCompletoResponse> buscaTodos() {
        return ordemServicoListaRepository.findAll()
                .stream()
                .map(ordemServicoListarAssembler::toModel)
                .collect(Collectors.toList());
    }
}
