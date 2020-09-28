package br.com.projuris.api.v1.cliente.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TelefoneCadastrarRequest {
    @NotBlank
    @Size(min = 3, max = 3)
    @ApiModelProperty(example = "063")
    private String ddd;

    @NotBlank
    @Size(min = 4, max = 15)
    @ApiModelProperty(example = "984674202")
    private String numero;

    @NotNull
    @ApiModelProperty(example = "true")
    private Boolean isWhatsApp;
}
