package br.com.projuris.domain.equipamento.repository.listar;

import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.infrastructure.interfaces.RepositoryDefault;

import java.util.Optional;

public interface EquipamentoListaRepository extends RepositoryDefault<Equipamento>, EquipamentoListaRepositoryCustom {

    Optional<Equipamento> findByPatrimonio(String patrimonio);
}

