package br.com.projuris.api.v1.equipamento.model.response;

import br.com.projuris.api.v1.problema.model.response.ProblemaResumidoResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EquipamentoCompletoResponse {

    @ApiModelProperty(example = "1000001")
    private String patrimonio;

    @ApiModelProperty(example = "Notebook")
    private String tipo;

    @ApiModelProperty(example = "Dell")
    private String marca;

    private List<ProblemaResumidoResponse> problemas;
}
