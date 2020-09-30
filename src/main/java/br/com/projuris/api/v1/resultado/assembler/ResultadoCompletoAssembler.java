package br.com.projuris.api.v1.resultado.assembler;

import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import br.com.projuris.domain.resultado.Resultado;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultadoCompletoAssembler implements AssamblerDefault<Resultado, ResultadoCompletoResponse> {
    private final ModelMapper modelMapper;

    public ResultadoCompletoAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ResultadoCompletoResponse toModel(Resultado resultado) {
        return modelMapper.map(resultado, ResultadoCompletoResponse.class);
    }

    @Override
    public List<ResultadoCompletoResponse> toListModel(List<Resultado> resultados) {
        if (temResultados(resultados)) {
            return resultados.stream().map(this::toModel).collect(Collectors.toList());
        }
        return null;
    }

    private boolean temResultados(List<Resultado> resultados) {
        return resultados != null;
    }
}
