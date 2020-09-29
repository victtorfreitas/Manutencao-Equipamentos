package br.com.projuris.domain.ordemservico;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "TB_ORDEM_SERVICO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Where(clause = "IS_ATIVO=true")
public class OrdemServico extends EntityAuditAbsDefault {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento equipamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @NotNull
    @CreationTimestamp
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusOrdemServicoEnum status;

    @ManyToMany
    @JoinTable(name = "TB_FUNCIONARIOS_OS",
            joinColumns = @JoinColumn(name = "ID_ORDEM_SERVICO"),
            inverseJoinColumns = @JoinColumn(name = "ID_FUNCIONARIO"))
    private List<Funcionario> funcionarios;
}
