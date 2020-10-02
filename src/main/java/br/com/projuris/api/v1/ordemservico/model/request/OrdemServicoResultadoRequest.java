package br.com.projuris.api.v1.ordemservico.model.request;

import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrdemServicoResultadoRequest {

    @NotNull
    @ApiModelProperty(example = "1")
    private Long id;

    @NotNull
    private StatusOrdemServicoEnum status;

}
