package br.com.projuris.domain.telefone.service.cadastrar;

import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.telefone.Telefone;
import br.com.projuris.domain.telefone.repository.cadastrar.TelefoneCadastrarRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneCadastrarServiceImpl
        extends ServiceAbsDefault<Telefone> implements TelefoneCadastrarService {

    private final TelefoneCadastrarRepository telefoneCadastrarRepository;

    @Autowired
    public TelefoneCadastrarServiceImpl(TelefoneCadastrarRepository telefoneCadastrarRepository) {
        super(telefoneCadastrarRepository);
        this.telefoneCadastrarRepository = telefoneCadastrarRepository;
    }

    @Override
    public void saveByCliente(Cliente cliente) {
        cliente.getTelefones().forEach(t -> t.setCliente(cliente));
        telefoneCadastrarRepository.saveAll(cliente.getTelefones());
    }
}
