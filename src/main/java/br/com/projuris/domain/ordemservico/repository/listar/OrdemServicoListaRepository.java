package br.com.projuris.domain.ordemservico.repository.listar;

import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.infrastructure.interfaces.RepositoryDefault;

import java.util.Optional;

public interface OrdemServicoListaRepository extends RepositoryDefault<OrdemServico>, OrdemServicoListaRepositoryCustom {
    Optional<OrdemServico> findFirstByEquipamento_Patrimonio(String patrimonio);
}

