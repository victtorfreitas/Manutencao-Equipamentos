package br.com.projuris.domain.resultado.service.cadastrar;

import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoSimplesRequest;
import br.com.projuris.api.v1.resultado.assembler.ResultadoCompletoAssembler;
import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import br.com.projuris.domain.resultado.Resultado;
import br.com.projuris.domain.resultado.repository.cadastrar.ResultadoCadastraRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultadoCadastraServiceImpl extends ServiceAbsDefault<Resultado> implements ResultadoCadastraService {

    private final ResultadoCadastraRepository resultadoCadastraRepository;
    private final ResultadoCompletoAssembler resultadoCompletoAssembler;

    @Autowired
    public ResultadoCadastraServiceImpl(ResultadoCadastraRepository resultadoCadastraRepository,
                                        ResultadoCompletoAssembler resultadoCompletoAssembler) {
        super(resultadoCadastraRepository);
        this.resultadoCadastraRepository = resultadoCadastraRepository;
        this.resultadoCompletoAssembler = resultadoCompletoAssembler;
    }

    @Override
    public ResultadoCompletoResponse iniciaAtendimento(OrdemServicoSimplesRequest ordemServico) {
        Resultado resultado = resultadoCadastraRepository.save(new Resultado(ordemServico.getId()));
        return resultadoCompletoAssembler.toModel(resultado);
    }
}
