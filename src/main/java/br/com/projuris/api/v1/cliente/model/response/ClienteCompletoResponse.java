package br.com.projuris.api.v1.cliente.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteCompletoResponse {

    @ApiModelProperty(example = "1")
    @JsonIgnore
    private Long id;

    @ApiModelProperty(example = "Victtor")
    private String nome;

    @ApiModelProperty(example = "027.297.301-19")
    private String cpf;

    @ApiModelProperty(example = "Victtorfreitas95@gmail.com")
    private String email;

    private List<TelefoneCompletoResponse> telefones;

    private List<EnderecoCompletoResponse> enderecos;
}
