package br.com.projuris.api.v1.equipamento.assembler;

import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.infrastructure.interfaces.DissamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoDisassembler implements DissamblerDefault<Equipamento, EquipamentoRequest> {

    private final ModelMapper modelMapper;

    public EquipamentoDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Equipamento toDomainObject(EquipamentoRequest equipamentoRequest) {
        return modelMapper.map(equipamentoRequest, Equipamento.class);
    }

    @Override
    public void copyToDomainObject(EquipamentoRequest equipamentoRequest, Equipamento equipamento) {
        modelMapper.map(equipamentoRequest, equipamento);
    }

}
