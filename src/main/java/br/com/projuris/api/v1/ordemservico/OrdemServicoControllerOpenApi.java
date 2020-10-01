package br.com.projuris.api.v1.ordemservico;

import br.com.projuris.api.v1.ordemservico.model.request.IniciarAtendimentoRequest;
import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoCadastrarRequest;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = "Ordem Serviço")
public interface OrdemServicoControllerOpenApi {

    @ApiOperation("Lista todas as Ordem de Serviços ativas")
    List<OrdemServicoCompletoResponse> listar();

    @ApiModelProperty("Cadastra uma nova ordem de serviço")
    OrdemServicoResumidoResponse cadastrar(OrdemServicoCadastrarRequest ordemServico);

    @ApiModelProperty("Iniciar atendimento da ordem de serviço")
    ResultadoCompletoResponse iniciarAtendimento(IniciarAtendimentoRequest atendimentoRequest);

    @ApiModelProperty("Filtra Ordem de Serviço por responsável")
    List<OrdemServicoResumidoResponse> listaPendentesPorResponsavel(Long idResponsavel);
}
