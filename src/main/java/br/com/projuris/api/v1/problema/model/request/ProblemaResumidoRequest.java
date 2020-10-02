package br.com.projuris.api.v1.problema.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProblemaResumidoRequest {
    @NotBlank
    @Size(max = 4000)
    @ApiModelProperty(example = "Ao ligar o notebook não da tela", required = true)
    private String descricao;
}
