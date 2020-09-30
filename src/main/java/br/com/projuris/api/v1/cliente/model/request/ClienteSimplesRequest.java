package br.com.projuris.api.v1.cliente.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteSimplesRequest {

    @NotNull
    @ApiModelProperty(example = "1")
    private Long id;
}
