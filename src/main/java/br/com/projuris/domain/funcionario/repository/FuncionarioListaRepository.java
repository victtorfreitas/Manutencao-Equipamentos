package br.com.projuris.domain.funcionario.repository;

import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.infrastructure.interfaces.RepositoryDefault;

import java.util.Optional;

public interface FuncionarioListaRepository extends RepositoryDefault<Funcionario>, FuncionarioListaRepositoryCustom {

    Optional<Funcionario> findByIdAndTipoFuncionario_Nome(Long id, String tipoFuncionario);
}

