package br.com.projuris.domain.telefone;

import br.com.projuris.domain.cliente.Cliente;
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
@Entity(name = "TB_TELEFONE")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Where(clause = "IS_ATIVO=true")
public class Telefone extends EntityAuditAbsDefault {

    @NotBlank
    @Size(min = 3, max = 3)
    private String ddd;

    @NotBlank
    @Size(min = 4, max = 15)
    private String numero;

    @NotNull
    @Column(name = "IS_WHATSAPP")
    private Boolean isWhatsApp;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
}
