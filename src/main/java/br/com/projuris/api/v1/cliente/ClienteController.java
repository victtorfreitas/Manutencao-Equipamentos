package br.com.projuris.api.v1.cliente;

import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.domain.cliente.service.hand.ClienteListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController implements ClienteControllerOpenApi {

    private final ClienteListaService clienteListaService;

    @Autowired
    public ClienteController(ClienteListaService clienteListaService) {
        this.clienteListaService = clienteListaService;
    }

    @Override
    @GetMapping
    public List<ClienteCompletoResponse> listar() {
        return clienteListaService.findClienteCompletoResponseAll();
    }
}

