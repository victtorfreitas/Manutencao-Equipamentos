package br.com.projuris.domain.ordemservico.repository.listar;

import br.com.projuris.domain.ordemservico.OrdemServico;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoListaRepositoryCustom {
    Optional<OrdemServico> findByIdAndStarted(Long id);

    List<OrdemServico> findByResponsavel(Long idResponsavel);
}
