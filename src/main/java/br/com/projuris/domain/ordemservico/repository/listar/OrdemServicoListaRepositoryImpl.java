package br.com.projuris.domain.ordemservico.repository.listar;

import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.QOrdemServico;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import br.com.projuris.infrastructure.abstracts.QueryDslAbsSuport;

import java.util.Objects;
import java.util.Optional;

public class OrdemServicoListaRepositoryImpl extends QueryDslAbsSuport<OrdemServico> implements OrdemServicoListaRepositoryCustom {
    public OrdemServicoListaRepositoryImpl() {
        super(OrdemServico.class);
    }

    @Override
    public Optional<OrdemServico> findByIdAndStarted(Long id) {
        QOrdemServico qOrdemServico = QOrdemServico.ordemServico;
        return Optional.ofNullable(Objects.requireNonNull(getQuerydsl())
                .createQuery(qOrdemServico)
                .select(qOrdemServico)
                .where(qOrdemServico.status.eq(StatusOrdemServicoEnum.CADASTRADA))
                .fetchFirst());
    }
}
