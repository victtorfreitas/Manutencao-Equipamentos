package br.com.projuris.domain.funcionario.repository;

import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.infrastructure.interfaces.RepositoryDefault;

public interface FuncionarioListaRepository extends RepositoryDefault<Funcionario>, FuncionarioListaRepositoryCustom {

}

