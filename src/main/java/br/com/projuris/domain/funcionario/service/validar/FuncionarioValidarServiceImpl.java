package br.com.projuris.domain.funcionario.service.validar;

import br.com.projuris.api.v1.funcionario.model.request.FuncionarioSimplesRequest;
import br.com.projuris.domain.exception.FuncionarioNaoTipoAtendenteException;
import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.domain.funcionario.repository.FuncionarioListaRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioValidarServiceImpl extends ServiceAbsDefault<Funcionario> implements FuncionarioValidarService {

    private final FuncionarioListaRepository funcionarioListaRepository;
    private final static String ATENDENTE = "Atendente";

    @Autowired
    public FuncionarioValidarServiceImpl(FuncionarioListaRepository funcionarioListaRepository) {
        super(funcionarioListaRepository);
        this.funcionarioListaRepository = funcionarioListaRepository;
    }

    @Override
    public void isAtendente(FuncionarioSimplesRequest funcionarioSimplesRequest) {
        funcionarioListaRepository
                .findById(funcionarioSimplesRequest.getId())
                .stream()
                .filter(f -> f.getTipoFuncionario().getNome().equalsIgnoreCase(ATENDENTE))
                .findAny()
                .orElseThrow(() -> new FuncionarioNaoTipoAtendenteException("Funcionario não é do tipo Atendente"));
    }
}
