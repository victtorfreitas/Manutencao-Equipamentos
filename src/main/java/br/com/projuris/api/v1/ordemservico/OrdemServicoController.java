package br.com.projuris.api.v1.ordemservico;

import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.domain.ordemservico.service.listar.OrdemServicoListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/ordemServicos")
public class OrdemServicoController implements OrdemServicoControllerOpenApi {

    private final OrdemServicoListaService ordemServicoListaService;

    @Autowired
    public OrdemServicoController(OrdemServicoListaService ordemServicoListaService) {
        this.ordemServicoListaService = ordemServicoListaService;
    }

    @Override
    @GetMapping
    public List<OrdemServicoCompletoResponse> listar() {
        return ordemServicoListaService.buscaTodos();
    }
}

