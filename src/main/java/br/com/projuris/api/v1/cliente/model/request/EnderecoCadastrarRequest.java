package br.com.projuris.api.v1.cliente.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EnderecoCadastrarRequest {

    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(example = "Alameda")
    private String logradouro;

    @NotBlank
    @Size(max = 30)
    @ApiModelProperty(example = "43")
    private String numero;

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(example = "Apartamento 103, bloco 04")
    private String complemento;

    @NotBlank
    @Size(max = 150)
    @ApiModelProperty(example = "Plano Diretor Sul")
    private String bairro;

    @NotBlank
    @Size(max = 8)
    @ApiModelProperty(example = "77000-000")
    private String cep;

    @NotBlank
    @Size(max = 150)
    @ApiModelProperty(example = "Palmas")
    private String cidade;

    @NotBlank
    @Size(max = 30)
    @ApiModelProperty(example = "TO")
    private String estado;
}

