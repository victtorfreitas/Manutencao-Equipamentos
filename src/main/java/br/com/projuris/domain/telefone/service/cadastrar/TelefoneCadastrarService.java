package br.com.projuris.domain.telefone.service.cadastrar;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.telefone.Telefone;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface TelefoneCadastrarService extends ServiceDefault<Telefone> {

    void saveByCliente(Cliente cliente);
}
