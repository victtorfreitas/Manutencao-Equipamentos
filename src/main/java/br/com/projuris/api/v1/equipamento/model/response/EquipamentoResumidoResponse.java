package br.com.projuris.api.v1.equipamento.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EquipamentoResumidoResponse {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "100001")
    private String patrimonio;
}
