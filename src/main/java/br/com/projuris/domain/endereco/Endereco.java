package br.com.projuris.domain.endereco;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "TB_ENDERECO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Endereco extends EntityAuditAbsDefault {

    @NotBlank
    @Max(100)
    private String logradouro;

    @NotBlank
    @Max(30)
    private String numero;

    @NotBlank
    @Max(250)
    private String complemento;

    @NotBlank
    @Max(150)
    private String bairro;

    @NotBlank
    @Max(8)
    private String cep;

    @NotBlank
    @Max(150)
    private String cidade;

    @NotBlank
    @Max(30)
    private String estado;

    @NotNull
    @ManyToOne
    private Cliente cliente;
}
