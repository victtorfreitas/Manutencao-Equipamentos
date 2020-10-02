package br.com.projuris.api.v1.ordemservico.model.request;

import br.com.projuris.api.v1.funcionario.model.request.FuncionarioSimplesRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IniciarAtendimentoRequest {

    private OrdemServicoSimplesRequest ordemServico;

    private FuncionarioSimplesRequest responsavel;
}
