package br.com.projuris.domain.telefone.service;

import br.com.projuris.domain.telefone.Telefone;
import br.com.projuris.domain.telefone.repository.listar.TelefoneListaRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneListaServiceImpl extends ServiceAbsDefault<Telefone> implements TelefoneListaService {

    private final TelefoneListaRepository telefoneListaRepository;

    @Autowired
    public TelefoneListaServiceImpl(TelefoneListaRepository telefoneListaRepository) {
        super(telefoneListaRepository);
        this.telefoneListaRepository = telefoneListaRepository;
    }

}
