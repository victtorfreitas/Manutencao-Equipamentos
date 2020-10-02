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

    @Override
    public Optional<OrdemServico> podePausar(Long ordemServicoId) {
        QOrdemServico qOrdemServico = QOrdemServico.ordemServico;

        var conditions = getRegraPodePausar(qOrdemServico, ordemServicoId);
        return Optional.ofNullable(Objects.requireNonNull(getQuerydsl())
                .createQuery(qOrdemServico)
                .select(qOrdemServico)
                .where(conditions)
                .fetchFirst());
    }

    @Override
    public Optional<OrdemServico> findByIdAndNotStatus(Long id, StatusOrdemServicoEnum... status) {
        QOrdemServico qOrdemServico = QOrdemServico.ordemServico;

        var conditions = getRegraPodeConcluir(qOrdemServico, id, status);
        return Optional.ofNullable(Objects.requireNonNull(getQuerydsl())
                .createQuery(qOrdemServico)
                .select(qOrdemServico)
                .where(conditions)
                .fetchFirst());
    }

    private BooleanBuilder getRegraPodeConcluir(QOrdemServico qOrdemServico, Long id, StatusOrdemServicoEnum... status) {
        return new BooleanBuilder()
                .and(qOrdemServico.status.notIn(status))
                .and(qOrdemServico.id.eq(id));
    }

    private BooleanBuilder getRegraPodePausar(QOrdemServico qOrdemServico, Long ordemServicoId) {
        return new BooleanBuilder()
                .and(qOrdemServico.status.eq(StatusOrdemServicoEnum.INICIADA)
                        .or(qOrdemServico.status.eq(StatusOrdemServicoEnum.RETOMADA)))
                .and(qOrdemServico.id.eq(ordemServicoId));
    }

    private BooleanBuilder getConditionsRestrictedByResponsavelAndStatusAndIsResponsavel(QOrdemServico qOrdemServico,
                                                                                         Long idResponsavel) {
        return new BooleanBuilder()
                .and(qOrdemServico.responsavel.id.eq(idResponsavel))
                .and(qOrdemServico.status.notIn(StatusOrdemServicoEnum.CONCLUIDA, StatusOrdemServicoEnum.CANCELADA))
                .and(qOrdemServico.responsavel.tipoFuncionario.nome.ne("Atendente"));
    }
}
