package br.com.projuris.domain.telefone;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "TB_TELEFONE")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Telefone extends EntityAuditAbsDefault {

    @NotBlank
    @Max(3)
    private String ddd;

    @NotBlank
    @Max(15)
    private String numero;

    @NotNull
    @Column(name = "IS_WHATSAPP")
    private Boolean isWhatsApp;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;
}
