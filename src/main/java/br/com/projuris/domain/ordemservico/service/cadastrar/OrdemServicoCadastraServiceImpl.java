package br.com.projuris.domain.ordemservico.service.cadastrar;

import br.com.projuris.api.v1.cliente.model.request.ClienteSimplesRequest;
import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.api.v1.funcionario.model.request.FuncionarioSimplesRequest;
import br.com.projuris.api.v1.ordemservico.assembler.OrdemServicoCadastrarDisassembler;
import br.com.projuris.api.v1.ordemservico.assembler.OrdemServicoListarAssembler;
import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoCadastrarRequest;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.domain.cliente.service.validar.ClienteValidaService;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.equipamento.service.cadastrar.EquipamentoCadastraService;
import br.com.projuris.domain.equipamento.service.listar.EquipamentoListaService;
import br.com.projuris.domain.funcionario.service.validar.FuncionarioValidarService;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.repository.cadastrar.OrdemServicoCadastraRepository;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoCadastraServiceImpl extends ServiceAbsDefault<OrdemServico> implements OrdemServicoCadastraService {

    private final OrdemServicoCadastraRepository ordemServicoCadastraRepository;
    private final OrdemServicoCadastrarDisassembler ordemServicoCadastrarDisassembler;
    private final OrdemServicoListarAssembler ordemServicoListarAssembler;
    private final EquipamentoListaService equipamentoListaService;
    private final EquipamentoCadastraService equipamentoCadastraService;
    private final FuncionarioValidarService funcionarioValidarService;
    private final ClienteValidaService clienteValidaService;

    @Autowired
    public OrdemServicoCadastraServiceImpl(OrdemServicoCadastraRepository ordemServicoCadastraRepository,
                                           OrdemServicoCadastrarDisassembler ordemServicoCadastrarDisassembler,
                                           OrdemServicoListarAssembler ordemServicoListarAssembler,
                                           EquipamentoListaService equipamentoListaService,
                                           EquipamentoCadastraService equipamentoCadastraService,
                                           FuncionarioValidarService funcionarioValidarService,
                                           ClienteValidaService clienteValidaService) {
        super(ordemServicoCadastraRepository);
        this.ordemServicoCadastraRepository = ordemServicoCadastraRepository;
        this.ordemServicoCadastrarDisassembler = ordemServicoCadastrarDisassembler;
        this.ordemServicoListarAssembler = ordemServicoListarAssembler;
        this.equipamentoListaService = equipamentoListaService;
        this.equipamentoCadastraService = equipamentoCadastraService;
        this.funcionarioValidarService = funcionarioValidarService;
        this.clienteValidaService = clienteValidaService;
    }

    @Override
    public OrdemServicoResumidoResponse cadastrar(OrdemServicoCadastrarRequest ordemServico) {
        validaOrdemServico(ordemServico);
        OrdemServico osBD = new OrdemServico();
        ordemServicoCadastrarDisassembler.copyToDomainObject(ordemServico, osBD);
        osBD.setEquipamento(buscaEquipamento(ordemServico.getEquipamento()));
        return ordemServicoListarAssembler.toResumeModel(ordemServicoCadastraRepository.save(osBD));
    }

    private void validaOrdemServico(OrdemServicoCadastrarRequest ordemServico) {
        validaCliente(ordemServico.getCliente());
        validaAtendente(ordemServico.getAtendente());
    }

    private void validaCliente(ClienteSimplesRequest cliente) {
        clienteValidaService.isCliente(cliente);
    }

    private void validaAtendente(FuncionarioSimplesRequest atendente) {
        funcionarioValidarService.isAtendente(atendente);
    }

    private Equipamento buscaEquipamento(EquipamentoRequest equipamento) {
        return equipamentoListaService
                .findByPatrimonio(equipamento.getPatrimonio())
                .orElseGet(() -> equipamentoCadastraService.save(equipamento));
    }
}
