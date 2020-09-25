package br.com.projuris.api.v1.cliente.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClienteCompletoResponse {

    @ApiModelProperty(example = "Victtor")
    @NotBlank
    @Size(min = 5, max = 250)
    private String nome;

    @ApiModelProperty(example = "027.297.301-19")
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @ApiModelProperty(example = "Victtorfreitas95@gmail.com")
    @Email
    private String email;
}
