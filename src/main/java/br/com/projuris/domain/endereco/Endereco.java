package br.com.projuris.domain.endereco;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.infrastructure.abstracts.EntityAuditAbsDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "TB_ENDERECO")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Endereco extends EntityAuditAbsDefault {

    @NotBlank
    @Size(max = 100)
    private String logradouro;

    @NotBlank
    @Size(max = 30)
    private String numero;

    @NotBlank
    @Size(max = 250)
    private String complemento;

    @NotBlank
    @Size(max = 150)
    private String bairro;

    @NotBlank
    @Size(max = 8)
    private String cep;

    @NotBlank
    @Size(max = 150)
    private String cidade;

    @NotBlank
    @Size(max = 30)
    private String estado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
}
