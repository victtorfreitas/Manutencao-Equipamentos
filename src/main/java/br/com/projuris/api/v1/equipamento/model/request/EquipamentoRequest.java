package br.com.projuris.api.v1.equipamento.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EquipamentoRequest {

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(example = "100001")
    private String patrimonio;

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(example = "Notebook", required = true)
    private String tipo;

    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(example = "Dell", required = true)
    private String marca;
}
