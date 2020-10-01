package br.com.projuris.api.v1.ordemservico.model.response;

import br.com.projuris.api.v1.equipamento.model.response.EquipamentoResumidoResponse;
import br.com.projuris.api.v1.funcionario.model.response.FuncionarioResumidoResponse;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrdemServicoResumidoResponse {

    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z")
    private LocalDateTime dataInicio;

    @ApiModelProperty(example = "Iniciada")
    private StatusOrdemServicoEnum status;

    private EquipamentoResumidoResponse equipamento;

    private FuncionarioResumidoResponse atendente;
}
