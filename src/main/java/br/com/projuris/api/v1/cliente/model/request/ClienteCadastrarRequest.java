package br.com.projuris.api.v1.cliente.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCadastrarRequest {

    private String nome;
    private String cpf;

}
