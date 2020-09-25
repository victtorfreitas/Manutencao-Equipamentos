package br.com.projuris.domain.cliente;

import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity(name = "TB_CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Where(clause = "IS_ATIVO=true")
public class Cliente extends EntityAuditAbsDefault {

    @NotBlank
    @Size(min = 5, max = 250)
    private String nome;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @Email
    @Max(value = 250)
    private String email;
}
