package br.com.projuris.domain.equipamento.service.cadastrar;

import br.com.projuris.api.v1.equipamento.assembler.EquipamentoDisassembler;
import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.equipamento.repository.cadastrar.EquipamentoCadastraRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoCadastraServiceImpl extends ServiceAbsDefault<Equipamento> implements EquipamentoCadastraService {

    private final EquipamentoCadastraRepository equipamentoCadastraRepository;
    private final EquipamentoDisassembler equipamentoDisassembler;

    @Autowired
    public EquipamentoCadastraServiceImpl(EquipamentoCadastraRepository equipamentoCadastraRepository,
                                          EquipamentoDisassembler equipamentoDisassembler) {
        super(equipamentoCadastraRepository);
        this.equipamentoCadastraRepository = equipamentoCadastraRepository;
        this.equipamentoDisassembler = equipamentoDisassembler;
    }

    @Override
    public Equipamento save(EquipamentoRequest equipamento) {
        return equipamentoCadastraRepository.save(equipamentoDisassembler.toDomainObject(equipamento));
    }
}
