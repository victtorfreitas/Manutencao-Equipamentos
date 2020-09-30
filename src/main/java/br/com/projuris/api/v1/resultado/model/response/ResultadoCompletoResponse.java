package br.com.projuris.api.v1.resultado.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResultadoCompletoResponse {

    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z")
    private LocalDateTime data;

    @ApiModelProperty(example = "Não foi possível concluir pois faltava uma tela correspondente ao modelo")
    private String descricao;
}
