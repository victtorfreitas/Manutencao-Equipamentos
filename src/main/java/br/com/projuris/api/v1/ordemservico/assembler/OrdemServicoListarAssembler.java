package br.com.projuris.api.v1.ordemservico.assembler;

import br.com.projuris.api.v1.cliente.assembler.ClienteAssembler;
import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.api.v1.equipamento.assembler.EquipamentoAssembler;
import br.com.projuris.api.v1.equipamento.model.response.EquipamentoCompletoResponse;
import br.com.projuris.api.v1.funcionario.assembler.FuncionarioResumidoAssembler;
import br.com.projuris.api.v1.funcionario.model.response.FuncionarioResumidoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResultadoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.api.v1.resultado.assembler.ResultadoCompletoAssembler;
import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.funcionario.Funcionario;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.resultado.Resultado;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdemServicoListarAssembler implements AssamblerDefault<OrdemServico, OrdemServicoCompletoResponse> {

    private final ModelMapper modelMapper;
    private final ClienteAssembler clienteAssembler;
    private final EquipamentoAssembler equipamentoAssembler;
    private final FuncionarioResumidoAssembler funcionarioResumidoAssembler;
    private final ResultadoCompletoAssembler resultadoCompletoAssembler;

    public OrdemServicoListarAssembler(ModelMapper modelMapper, ClienteAssembler clienteAssembler,
                                       EquipamentoAssembler equipamentoAssembler,
                                       FuncionarioResumidoAssembler funcionarioResumidoAssembler,
                                       ResultadoCompletoAssembler resultadoCompletoAssembler) {
        this.modelMapper = modelMapper;
        this.clienteAssembler = clienteAssembler;
        this.equipamentoAssembler = equipamentoAssembler;
        this.funcionarioResumidoAssembler = funcionarioResumidoAssembler;
        this.resultadoCompletoAssembler = resultadoCompletoAssembler;
    }

    @Override
    public OrdemServicoCompletoResponse toModel(OrdemServico ordemServico) {
        OrdemServicoCompletoResponse osResponse = modelMapper.map(ordemServico, OrdemServicoCompletoResponse.class);
        preencheDadosAdicionais(ordemServico, osResponse);
        return osResponse;
    }

    private void preencheDadosAdicionais(OrdemServico ordemServico, OrdemServicoCompletoResponse osResponse) {
        osResponse.setCliente(buscaCliente(ordemServico.getCliente()));
        osResponse.setEquipamento(buscaEquipamento(ordemServico.getEquipamento()));
        osResponse.setAtendente(buscaAtendente(ordemServico.getAtendente()));
        osResponse.setResultados(buscaResultados(ordemServico.getResultados()));
    }

    private List<ResultadoCompletoResponse> buscaResultados(List<Resultado> resultados) {
        return resultadoCompletoAssembler.toListModel(resultados);
    }

    private FuncionarioResumidoResponse buscaAtendente(Funcionario atendente) {
        return funcionarioResumidoAssembler.toModel(atendente);
    }

    private EquipamentoCompletoResponse buscaEquipamento(Equipamento equipamento) {
        return equipamentoAssembler.toModel(equipamento);
    }

    private ClienteCompletoResponse buscaCliente(Cliente cliente) {
        return clienteAssembler.toModel(cliente);
    }

    @Override
    public List<OrdemServicoCompletoResponse> toListModel(List<OrdemServico> ordemServicos) {
        return ordemServicos.stream().map(this::toModel).collect(Collectors.toList());
    }

    public OrdemServicoResumidoResponse toResumeModel(OrdemServico os) {
        return modelMapper.map(os, OrdemServicoResumidoResponse.class);
    }

    public OrdemServicoResultadoResponse toResultadoModel(OrdemServico ordemServico,
                                                          ResultadoCompletoResponse resultadoCompletoResponse) {
        OrdemServicoResultadoResponse ordemServicoResultadoResponse =
                modelMapper.map(ordemServico, OrdemServicoResultadoResponse.class);
        ordemServicoResultadoResponse.setResultado(resultadoCompletoResponse);
        return ordemServicoResultadoResponse;
    }
}
