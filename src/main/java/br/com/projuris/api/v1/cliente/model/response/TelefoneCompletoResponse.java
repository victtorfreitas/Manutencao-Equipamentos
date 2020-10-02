package br.com.projuris.api.v1.cliente.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TelefoneCompletoResponse {

    @ApiModelProperty(example = "063")
    private String ddd;

    @ApiModelProperty(example = "984674202")
    private String numero;

    @ApiModelProperty(example = "true")
    private Boolean isWhatsApp;

}
