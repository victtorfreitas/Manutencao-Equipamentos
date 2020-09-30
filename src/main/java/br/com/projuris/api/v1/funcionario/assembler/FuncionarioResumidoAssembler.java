package br.com.projuris.api.v1.funcionario.assembler;

import br.com.projuris.api.v1.funcionario.model.response.FuncionarioResumidoResponse;
import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FuncionarioResumidoAssembler implements AssamblerDefault<Funcionario, FuncionarioResumidoResponse> {
    private final ModelMapper modelMapper;

    public FuncionarioResumidoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public FuncionarioResumidoResponse toModel(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioResumidoResponse.class);
    }

    @Override
    public List<FuncionarioResumidoResponse> toListModel(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(this::toModel).collect(Collectors.toList());
    }
}
