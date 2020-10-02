package br.com.projuris.domain.equipamento.service.validar;

import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.equipamento.repository.listar.EquipamentoListaRepository;
import br.com.projuris.domain.exception.EquipamentoNaoUnicoAtivoException;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoValidaServiceImpl extends ServiceAbsDefault<Equipamento> implements EquipamentoValidaService {

    private final EquipamentoListaRepository equipamentoListaRepository;

    @Autowired
    public EquipamentoValidaServiceImpl(EquipamentoListaRepository equipamentoListaRepository) {
        super(equipamentoListaRepository);
        this.equipamentoListaRepository = equipamentoListaRepository;
    }

    @Override
    public void isUnicoAtivo(EquipamentoRequest equipamento) {
        equipamentoListaRepository
                .findByPatrimonio(equipamento.getPatrimonio())
                .orElseThrow(() -> new EquipamentoNaoUnicoAtivoException(equipamento.getPatrimonio()));
    }
}
