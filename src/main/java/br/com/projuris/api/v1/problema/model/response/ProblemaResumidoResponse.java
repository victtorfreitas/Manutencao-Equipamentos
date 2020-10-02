package br.com.projuris.api.v1.problema.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProblemaResumidoResponse {

    @ApiModelProperty(example = "Ao ligar o notebook não da tela", required = true)
    private String descricao;
}
