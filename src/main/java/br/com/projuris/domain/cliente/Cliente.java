package br.com.projuris.domain.cliente;

import br.com.projuris.domain.telefone.Telefone;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<Telefone> telefones;

    public boolean temTelefones() {
        return this.telefones != null;
    }
}
