package br.com.projuris.domain.equipamento.service.listar;

import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.equipamento.repository.listar.EquipamentoListaRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipamentoListaServiceImpl extends ServiceAbsDefault<Equipamento> implements EquipamentoListaService {

    private final EquipamentoListaRepository equipamentoListaRepository;

    @Autowired
    public EquipamentoListaServiceImpl(EquipamentoListaRepository equipamentoListaRepository) {
        super(equipamentoListaRepository);
        this.equipamentoListaRepository = equipamentoListaRepository;
    }

    @Override
    public Optional<Equipamento> findByPatrimonio(String patrimonio) {
        return equipamentoListaRepository.findByPatrimonio(patrimonio);
    }
}
