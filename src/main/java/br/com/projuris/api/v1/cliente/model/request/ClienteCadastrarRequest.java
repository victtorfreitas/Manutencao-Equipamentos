package br.com.projuris.api.v1.cliente.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class ClienteCadastrarRequest {

    @NotBlank
    @Size(min = 5, max = 250)
    @ApiModelProperty(example = "Victtor Araújo Freitas", required = true)
    private String nome;

    @NotBlank
    @Size(min = 11, max = 11)
    @ApiModelProperty(example = "02729712155", required = true)
    private String cpf;

    @Email
    @ApiModelProperty(example = "victtorfreitas95@gmail.com")
    private String email;

    @Valid
    @NotNull
    private List<TelefoneCadastrarRequest> telefones;

    @Valid
    @NotNull
    private List<EnderecoCadastrarRequest> enderecos;

    public boolean temTelefones() {
        return this.telefones != null;
    }

}
