package br.com.projuris.domain.ordemservico.repository.listar;

import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.QOrdemServico;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import br.com.projuris.infrastructure.abstracts.QueryDslAbsSuport;
import com.querydsl.core.BooleanBuilder;

import java.util.List;
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

    @Override
    public List<OrdemServico> findByResponsavel(Long idResponsavel) {
        QOrdemServico qOrdemServico = QOrdemServico.ordemServico;
        BooleanBuilder conditions = getConditionsRestrictedByResponsavelAndStatusAndIsResponsavel(qOrdemServico, idResponsavel);
        return Objects.requireNonNull(getQuerydsl()).createQuery(qOrdemServico)
                .select(qOrdemServico)
                .where(conditions)
                .fetch();
    }

    private BooleanBuilder getConditionsRestrictedByResponsavelAndStatusAndIsResponsavel(QOrdemServico qOrdemServico,
                                                                                         Long idResponsavel) {
        return new BooleanBuilder()
                .and(qOrdemServico.responsavel.id.eq(idResponsavel))
                .and(qOrdemServico.status.notIn(StatusOrdemServicoEnum.CONCLUIDA, StatusOrdemServicoEnum.CANCELADA))
                .and(qOrdemServico.responsavel.tipoFuncionario.nome.ne("Atendente"));
    }
}
