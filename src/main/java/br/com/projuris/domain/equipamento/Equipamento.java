package br.com.projuris.domain.equipamento;

import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity(name = "TB_EQUIPAMENTO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Equipamento extends EntityAuditAbsDefault {
    @NotBlank
    @Size(max = 250)
    private String tipo;
    @NotBlank
    @Size(max = 250)
    private String marca;
}
