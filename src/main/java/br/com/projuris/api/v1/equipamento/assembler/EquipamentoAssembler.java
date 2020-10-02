package br.com.projuris.api.v1.equipamento.assembler;

import br.com.projuris.api.v1.equipamento.model.response.EquipamentoCompletoResponse;
import br.com.projuris.api.v1.problema.assembler.ProblemaCadastraAssembler;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.problema.Problema;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipamentoAssembler implements AssamblerDefault<Equipamento, EquipamentoCompletoResponse> {
    private final ModelMapper modelMapper;
    private final ProblemaCadastraAssembler problemaCadastraAssembler;

    public EquipamentoAssembler(ModelMapper modelMapper, ProblemaCadastraAssembler problemaCadastraAssembler) {
        this.modelMapper = modelMapper;
        this.problemaCadastraAssembler = problemaCadastraAssembler;
    }

    @Override
    public EquipamentoCompletoResponse toModel(Equipamento equipamento) {
        EquipamentoCompletoResponse equipamentoCompletoResponse =
                modelMapper.map(equipamento, EquipamentoCompletoResponse.class);
        preencheProblemas(equipamentoCompletoResponse, equipamento.getProblemas());
        return equipamentoCompletoResponse;
    }

    private void preencheProblemas(EquipamentoCompletoResponse equipamentoCompletoResponse, List<Problema> problemas) {
        equipamentoCompletoResponse.setProblemas(problemaCadastraAssembler.toListModel(problemas));
    }

    @Override
    public List<EquipamentoCompletoResponse> toListModel(List<Equipamento> equipamentos) {
        return equipamentos.stream().map(this::toModel).collect(Collectors.toList());
    }
}
