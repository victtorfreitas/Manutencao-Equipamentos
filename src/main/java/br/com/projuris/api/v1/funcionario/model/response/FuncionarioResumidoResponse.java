package br.com.projuris.api.v1.funcionario.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioResumidoResponse {

    @ApiModelProperty(example = "Fabricio Ribeiro")
    private String nome;

    @ApiModelProperty(example = "20160101")
    private String matricula;
}
