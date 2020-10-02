package br.com.projuris.api.v1.equipamento.model.response;

import br.com.projuris.api.v1.problema.model.response.ProblemaResumidoResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class EquipamentoResumidoResponse {

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(example = "100001")
    private String patrimonio;

    private List<ProblemaResumidoResponse> problemas;
}
