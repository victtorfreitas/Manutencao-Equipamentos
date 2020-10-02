package br.com.projuris.api.v1.funcionario.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FuncionarioSimplesRequest {

    @NotNull
    @ApiModelProperty(example = "1")
    private Long id;
}
