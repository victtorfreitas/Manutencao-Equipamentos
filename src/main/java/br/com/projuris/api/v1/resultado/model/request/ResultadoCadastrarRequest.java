package br.com.projuris.api.v1.resultado.model.request;

import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoSimplesRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ResultadoCadastrarRequest {

    @NotBlank
    @Size(max = 4000)
    @ApiModelProperty(example = "Não foi possível concluir pois faltava uma tela correspondente ao modelo")
    private String descricao;

    @Valid
    @NotNull
    private OrdemServicoSimplesRequest ordemServico;
}
