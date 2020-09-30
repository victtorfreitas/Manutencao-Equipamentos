package br.com.projuris.api.v1.ordemservico.model.request;

import br.com.projuris.api.v1.cliente.model.request.ClienteSimplesRequest;
import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.api.v1.funcionario.model.request.FuncionarioSimplesRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrdemServicoCadastrarRequest {

    @Valid
    @NotNull
    private EquipamentoRequest equipamento;

    @Valid
    @NotNull
    private ClienteSimplesRequest cliente;

    @Valid
    @NotNull
    private FuncionarioSimplesRequest atendente;
}
