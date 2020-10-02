package br.com.projuris.domain.funcionario.tipofuncionario;

import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity(name = "TB_TIPO_FUNCIONARIO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Where(clause = "IS_ATIVO=true")
public class TipoFuncionario extends EntityAuditAbsDefault {

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotBlank
    @Size(max = 300)
    private String descricao;
}
