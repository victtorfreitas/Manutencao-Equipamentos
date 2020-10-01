package br.com.projuris.api.v1.ordemservico;

import br.com.projuris.api.v1.ordemservico.model.request.IniciarAtendimentoRequest;
import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoCadastrarRequest;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResultadoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.api.v1.resultado.model.request.ResultadoCadastrarRequest;
import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = "Ordem Serviço")
public interface OrdemServicoControllerOpenApi {

    @ApiOperation("Lista todas as Ordem de Serviços ativas")
    List<OrdemServicoCompletoResponse> listar();

    @ApiOperation("Cadastra uma nova ordem de serviço")
    OrdemServicoResumidoResponse cadastrar(OrdemServicoCadastrarRequest ordemServico);

    @ApiOperation("Iniciar atendimento da ordem de serviço")
    ResultadoCompletoResponse iniciarAtendimento(IniciarAtendimentoRequest atendimentoRequest);

    @ApiOperation("Filtra Ordem de Serviço por responsável")
    List<OrdemServicoResumidoResponse> listaPendentesPorResponsavel(Long idResponsavel);

    @ApiOperation("Atualiza status ordem de serviço")
    OrdemServicoResultadoResponse atualizaOrdemServico(ResultadoCadastrarRequest resultado);
}
