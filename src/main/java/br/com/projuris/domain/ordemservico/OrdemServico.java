package br.com.projuris.domain.ordemservico;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.domain.resultado.Resultado;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "TB_ORDEM_SERVICO")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Where(clause = "IS_ATIVO=true")
public class OrdemServico extends EntityAuditAbsDefault {

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO")
    private Equipamento equipamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @NotNull
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusOrdemServicoEnum status;

    @ManyToOne
    @JoinColumn(name = "ID_ATENDENTE")
    private Funcionario atendente;

    @ManyToOne
    @JoinColumn(name = "ID_RESPONSAVEL")
    private Funcionario responsavel;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
    private List<Resultado> resultados;

    public OrdemServico() {
        this.dataInicio = LocalDateTime.now();
        this.status = StatusOrdemServicoEnum.CADASTRADA;
    }

    public OrdemServico(Long id) {
        this.setId(id);
    }
}
