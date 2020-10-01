package br.com.projuris.domain.funcionario.service.validar;

import br.com.projuris.api.v1.funcionario.model.request.FuncionarioSimplesRequest;
import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface FuncionarioValidarService extends ServiceDefault<Funcionario> {

    void isAtendente(FuncionarioSimplesRequest funcionarioSimplesRequest);

    void isResponsavel(FuncionarioSimplesRequest funcionario);
}
