package br.com.projuris.api.v1.ordemservico.model.response;

import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class OrdemServicoResultadoResponse {
    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z")
    private LocalDateTime dataInico;

    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z")
    private LocalDateTime dataFim;

    @ApiModelProperty(example = "INICIADA")
    private StatusOrdemServicoEnum status;

    private ResultadoCompletoResponse resultado;
}
