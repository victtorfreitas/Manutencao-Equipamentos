package br.com.projuris.api.v1.cliente.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClienteResumidoResponse {
    @ApiModelProperty(example = "Victtor")
    private String nome;
}
