package br.com.projuris.api.v1.cliente;

import br.com.projuris.api.v1.cliente.model.request.ClienteCadastrarRequest;
import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.domain.cliente.service.listar.ClienteListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController implements ClienteControllerOpenApi {

    private final ClienteListaService clienteListaService;

    @Autowired
    public ClienteController(ClienteListaService clienteListaService) {
        this.clienteListaService = clienteListaService;
    }

    @Override
    @GetMapping
    public List<ClienteCompletoResponse> listar() {
        return clienteListaService.buscaTodos();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteCompletoResponse cadastrar(@RequestBody @Valid ClienteCadastrarRequest clienteRequest) {
        return clienteListaService.cadastrar(clienteRequest);
    }
}
