package br.com.projuris.api.v1.cliente.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoCompletoResponse {
    @ApiModelProperty(example = "Alameda")
    private String logradouro;

    @ApiModelProperty(example = "43")
    private String numero;

    @ApiModelProperty(example = "Apartamento 103, bloco 04")
    private String complemento;

    @ApiModelProperty(example = "Plano Diretor Sul")
    private String bairro;

    @ApiModelProperty(example = "77000-000")
    private String cep;

    @ApiModelProperty(example = "Palmas")
    private String cidade;

    @ApiModelProperty(example = "TO")
    private String estado;
}
