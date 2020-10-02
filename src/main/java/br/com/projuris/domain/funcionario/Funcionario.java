package br.com.projuris.domain.funcionario;

import br.com.projuris.domain.funcionario.tipofuncionario.TipoFuncionario;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "TB_FUNCIONARIO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Where(clause = "IS_ATIVO=true")
public class Funcionario extends EntityAuditAbsDefault {

    @NotBlank
    @Size(max = 250)
    private String nome;

    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String matricula;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_TIPO")
    private TipoFuncionario tipoFuncionario;

}
