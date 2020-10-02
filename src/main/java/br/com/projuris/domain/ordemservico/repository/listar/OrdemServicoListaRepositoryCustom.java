package br.com.projuris.domain.ordemservico.repository.listar;

import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoListaRepositoryCustom {
    Optional<OrdemServico> findByIdAndStarted(Long id);

    List<OrdemServico> findByResponsavel(Long idResponsavel);

    Optional<OrdemServico> podePausar(Long ordemServicoId);

    Optional<OrdemServico> findByIdAndNotStatus(Long id, StatusOrdemServicoEnum... status);
}
