package br.com.projuris.api.v1.equipamento.model.request;

import br.com.projuris.api.v1.problema.model.request.ProblemaResumidoRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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

    @Valid
    @NotNull
    List<ProblemaResumidoRequest> problemas;
}
