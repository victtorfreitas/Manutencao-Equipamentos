package br.com.projuris.api.v1.ordemservico.model.response;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.api.v1.equipamento.model.response.EquipamentoCompletoResponse;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrdemServicoCompletoResponse {

    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z")
    private LocalDateTime dataInicio;

    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z")
    private LocalDateTime dataFim;

    @ApiModelProperty(example = "Concluída")
    private StatusOrdemServicoEnum status;

    private ClienteCompletoResponse cliente;

    private EquipamentoCompletoResponse equipamento;
}
