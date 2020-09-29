package br.com.projuris.api.v1.equipamento.assembler;

import br.com.projuris.api.v1.equipamento.model.response.EquipamentoCompletoResponse;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipamentoAssembler implements AssamblerDefault<Equipamento, EquipamentoCompletoResponse> {
    private final ModelMapper modelMapper;

    public EquipamentoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EquipamentoCompletoResponse toModel(Equipamento equipamento) {
        return modelMapper.map(equipamento, EquipamentoCompletoResponse.class);
    }

    @Override
    public List<EquipamentoCompletoResponse> toListModel(List<Equipamento> equipamentos) {
        return equipamentos.stream().map(this::toModel).collect(Collectors.toList());
    }
}
