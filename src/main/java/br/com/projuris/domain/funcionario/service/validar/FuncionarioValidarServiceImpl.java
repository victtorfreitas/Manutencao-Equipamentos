package br.com.projuris.domain.funcionario.service.validar;

import br.com.projuris.api.v1.funcionario.model.request.FuncionarioSimplesRequest;
import br.com.projuris.domain.exception.NaoAtendenteEncontradaException;
import br.com.projuris.domain.exception.NaoResponsavelEncontradaException;
import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.domain.funcionario.repository.FuncionarioListaRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioValidarServiceImpl extends ServiceAbsDefault<Funcionario> implements FuncionarioValidarService {

    private final FuncionarioListaRepository funcionarioListaRepository;
    private final static String ATENDENTE = "Atendente";
    private final static String TECNICO = "Técnico de computadores";

    @Autowired
    public FuncionarioValidarServiceImpl(FuncionarioListaRepository funcionarioListaRepository) {
        super(funcionarioListaRepository);
        this.funcionarioListaRepository = funcionarioListaRepository;
    }

    @Override
    public void isAtendente(FuncionarioSimplesRequest funcionarioSimplesRequest) {
        funcionarioListaRepository
                .findByIdAndTipoFuncionario_Nome(funcionarioSimplesRequest.getId(), ATENDENTE)
                .orElseThrow(() -> new NaoAtendenteEncontradaException(funcionarioSimplesRequest.getId()));
    }

    @Override
    public void isResponsavel(FuncionarioSimplesRequest funcionario) {
        funcionarioListaRepository
                .findByIdAndTipoFuncionario_Nome(funcionario.getId(), TECNICO)
                .orElseThrow(() -> new NaoResponsavelEncontradaException(funcionario.getId()));

    }
}
