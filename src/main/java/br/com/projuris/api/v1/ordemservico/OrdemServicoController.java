package br.com.projuris.api.v1.ordemservico;

import br.com.projuris.api.v1.ordemservico.model.request.IniciarAtendimentoRequest;
import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoCadastrarRequest;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResultadoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.api.v1.resultado.model.request.ResultadoCadastrarRequest;
import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import br.com.projuris.domain.ordemservico.service.cadastrar.OrdemServicoCadastraService;
import br.com.projuris.domain.ordemservico.service.listar.OrdemServicoListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/ordem-servicos", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdemServicoController implements OrdemServicoControllerOpenApi {

    private final OrdemServicoListaService ordemServicoListaService;
    private final OrdemServicoCadastraService ordemServicoCadastraService;

    @Autowired
    public OrdemServicoController(OrdemServicoListaService ordemServicoListaService,
                                  OrdemServicoCadastraService ordemServicoCadastraService) {
        this.ordemServicoListaService = ordemServicoListaService;
        this.ordemServicoCadastraService = ordemServicoCadastraService;
    }

    @Override
    @GetMapping
    public List<OrdemServicoCompletoResponse> listar() {
        return ordemServicoListaService.buscaTodos();
    }

    @Override
    @GetMapping("/resumo")
    public List<OrdemServicoResumidoResponse> listarResumido() {
        return ordemServicoListaService.buscaTodosResumido();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoResumidoResponse cadastrar(@Valid @RequestBody OrdemServicoCadastrarRequest ordemServico) {
        return ordemServicoCadastraService.cadastrar(ordemServico);
    }

    @Override
    @PutMapping(path = "/iniciar-atendimento")
    @ResponseStatus(HttpStatus.OK)
    public ResultadoCompletoResponse iniciarAtendimento(@Valid @RequestBody IniciarAtendimentoRequest atendimentoRequest) {
        return ordemServicoCadastraService
                .iniciarAtendimento(atendimentoRequest.getOrdemServico(), atendimentoRequest.getResponsavel());
    }

    @Override
    @GetMapping(path = "/responsavel/{idResponsavel}")
    public List<OrdemServicoResumidoResponse> listaPendentesPorResponsavel(@PathVariable Long idResponsavel) {
        return ordemServicoListaService.listaPendentesPorResponsavel(idResponsavel);
    }

    @Override
    @PutMapping(path = "/pausa-atendimento")
    public OrdemServicoResultadoResponse pausaOrdemServico(@Valid @RequestBody ResultadoCadastrarRequest resultado) {
        return ordemServicoCadastraService.pausaAntendimento(resultado);
    }

    @Override
    @PutMapping(path = "/retoma-atendimento")
    public OrdemServicoResultadoResponse retomarOrdemServico(@Valid @RequestBody ResultadoCadastrarRequest resultado) {
        return ordemServicoCadastraService.retomarAntendimento(resultado);
    }
}

