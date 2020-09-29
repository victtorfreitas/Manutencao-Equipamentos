package br.com.projuris.domain.ordemservico;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity(name = "TB_ORDEM_SERVICO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrdemServico extends EntityAuditAbsDefault {

    @NotNull
    @ManyToOne
    private Equipamento equipamento;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotNull
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusOrdemServicoEnum status;
}
