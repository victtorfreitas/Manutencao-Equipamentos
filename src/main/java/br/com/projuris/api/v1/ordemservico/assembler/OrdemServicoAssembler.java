package br.com.projuris.api.v1.ordemservico.assembler;

import br.com.projuris.api.v1.cliente.assembler.ClienteAssembler;
import br.com.projuris.api.v1.cliente.model.response.ClienteCompletoResponse;
import br.com.projuris.api.v1.equipamento.assembler.EquipamentoAssembler;
import br.com.projuris.api.v1.equipamento.model.response.EquipamentoCompletoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoCompletoResponse;
import br.com.projuris.domain.cliente.Cliente;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.infrastructure.interfaces.AssamblerDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdemServicoAssembler implements AssamblerDefault<OrdemServico, OrdemServicoCompletoResponse> {

    private final ModelMapper modelMapper;
    private final ClienteAssembler clienteAssembler;
    private final EquipamentoAssembler equipamentoAssembler;

    public OrdemServicoAssembler(ModelMapper modelMapper, ClienteAssembler clienteAssembler,
                                 EquipamentoAssembler equipamentoAssembler) {
        this.modelMapper = modelMapper;
        this.clienteAssembler = clienteAssembler;
        this.equipamentoAssembler = equipamentoAssembler;
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
}
