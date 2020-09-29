package br.com.projuris.domain.resultado;

import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity(name = "TB_RESULTADO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Resultado extends EntityAuditAbsDefault {

    @NotNull
    @CreationTimestamp
    private LocalDateTime data;

    @NotBlank
    @Size(max = 4000)
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_ORDEM_SERVICO")
    private OrdemServico ordemServico;

}
