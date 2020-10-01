package br.com.projuris.domain.ordemservico.service.cadastrar;

import br.com.projuris.api.v1.cliente.model.request.ClienteSimplesRequest;
import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.api.v1.funcionario.model.request.FuncionarioSimplesRequest;
import br.com.projuris.api.v1.ordemservico.assembler.OrdemServicoCadastrarDisassembler;
import br.com.projuris.api.v1.ordemservico.assembler.OrdemServicoListarAssembler;
import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoCadastrarRequest;
import br.com.projuris.api.v1.ordemservico.model.request.OrdemServicoSimplesRequest;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResultadoResponse;
import br.com.projuris.api.v1.ordemservico.model.response.OrdemServicoResumidoResponse;
import br.com.projuris.api.v1.resultado.model.request.ResultadoCadastrarRequest;
import br.com.projuris.api.v1.resultado.model.response.ResultadoCompletoResponse;
import br.com.projuris.domain.cliente.service.validar.ClienteValidaService;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.domain.equipamento.service.cadastrar.EquipamentoCadastraService;
import br.com.projuris.domain.equipamento.service.listar.EquipamentoListaService;
import br.com.projuris.domain.equipamento.service.validar.EquipamentoValidaService;
import br.com.projuris.domain.funcionario.service.validar.FuncionarioValidarService;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import br.com.projuris.domain.ordemservico.repository.cadastrar.OrdemServicoCadastraRepository;
import br.com.projuris.domain.ordemservico.service.validar.OrdemServicoValidaService;
import br.com.projuris.domain.resultado.service.cadastrar.ResultadoCadastraService;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class OrdemServicoCadastraServiceImpl extends ServiceAbsDefault<OrdemServico> implements OrdemServicoCadastraService {

    private final OrdemServicoCadastraRepository ordemServicoCadastraRepository;
    private final OrdemServicoCadastrarDisassembler ordemServicoCadastrarDisassembler;
    private final OrdemServicoListarAssembler ordemServicoListarAssembler;
    private final EquipamentoListaService equipamentoListaService;
    private final EquipamentoCadastraService equipamentoCadastraService;
    private final FuncionarioValidarService funcionarioValidarService;
    private final ClienteValidaService clienteValidaService;
    private final OrdemServicoValidaService ordemServicoValidaService;
    private final ResultadoCadastraService resultadoCadastraService;
    private final EquipamentoValidaService equipamentoValidaService;

    @Autowired
    public OrdemServicoCadastraServiceImpl(OrdemServicoCadastraRepository ordemServicoCadastraRepository,
                                           OrdemServicoCadastrarDisassembler ordemServicoCadastrarDisassembler,
                                           OrdemServicoListarAssembler ordemServicoListarAssembler,
                                           EquipamentoListaService equipamentoListaService,
                                           EquipamentoCadastraService equipamentoCadastraService,
                                           FuncionarioValidarService funcionarioValidarService,
                                           ClienteValidaService clienteValidaService,
                                           OrdemServicoValidaService ordemServicoValidaService,
                                           ResultadoCadastraService resultadoCadastraService,
                                           EquipamentoValidaService equipamentoValidaService) {
        super(ordemServicoCadastraRepository);
        this.ordemServicoCadastraRepository = ordemServicoCadastraRepository;
        this.ordemServicoCadastrarDisassembler = ordemServicoCadastrarDisassembler;
        this.ordemServicoListarAssembler = ordemServicoListarAssembler;
        this.equipamentoListaService = equipamentoListaService;
        this.equipamentoCadastraService = equipamentoCadastraService;
        this.funcionarioValidarService = funcionarioValidarService;
        this.clienteValidaService = clienteValidaService;
        this.ordemServicoValidaService = ordemServicoValidaService;
        this.resultadoCadastraService = resultadoCadastraService;
        this.equipamentoValidaService = equipamentoValidaService;
    }

    @Override
    public OrdemServicoResumidoResponse cadastrar(OrdemServicoCadastrarRequest ordemServico) {
        validaOrdemServico(ordemServico);
        OrdemServico osBD = new OrdemServico();
        ordemServicoCadastrarDisassembler.copyToDomainObject(ordemServico, osBD);
        osBD.setEquipamento(buscaEquipamento(ordemServico.getEquipamento()));
        return ordemServicoListarAssembler.toResumeModel(ordemServicoCadastraRepository.save(osBD));
    }

    @Override
    @Transient
    public ResultadoCompletoResponse iniciarAtendimento(OrdemServicoSimplesRequest ordemServico,
                                                        FuncionarioSimplesRequest funcionario) {
        validaInicioAtendimento(ordemServico, funcionario);
        iniciaAtendimentoOrdemServico(ordemServico.getId());
        return resultadoCadastraService.iniciaAtendimento(ordemServico);
    }

    @Override
    public OrdemServicoResultadoResponse atualiza(ResultadoCadastrarRequest resultado) {
        Long ordemServicoId = resultado.getOrdemServico().getId();
        validaOrdemServico(ordemServicoId);
        atualizaStatusOrdemServico(ordemServicoId, resultado.getOrdemServico().getStatus());
        return null;
    }

    private void validaOrdemServico(Long id) {
        ordemServicoValidaService.isOrdemServico(id);
    }

    private void iniciaAtendimentoOrdemServico(Long id) {
        ordemServicoCadastraRepository
                .findById(id)
                .ifPresent(os -> ordemServicoCadastraRepository
                        .save(atualizaStatusOrdemServico(os, StatusOrdemServicoEnum.INICIADA)));
    }

    private void atualizaStatusOrdemServico(Long id, StatusOrdemServicoEnum status) {
        ordemServicoCadastraRepository
                .findById(id)
                .ifPresent(os -> ordemServicoCadastraRepository
                        .save(atualizaStatusOrdemServico(os, status)));
    }

    private OrdemServico atualizaStatusOrdemServico(OrdemServico os, StatusOrdemServicoEnum iniciada) {
        os.setStatus(iniciada);
        return os;
    }

    private void validaInicioAtendimento(OrdemServicoSimplesRequest ordemServico,
                                         FuncionarioSimplesRequest funcionario) {
        validaOrdemServico(ordemServico);
        validaResponsavel(funcionario);
    }

    private void validaResponsavel(FuncionarioSimplesRequest funcionario) {
        funcionarioValidarService.isResponsavel(funcionario);
    }

    private void validaOrdemServico(OrdemServicoSimplesRequest ordemServico) {
        ordemServicoValidaService.isOrdemServico(ordemServico);
    }

    private void validaOrdemServico(OrdemServicoCadastrarRequest ordemServico) {
        validaEquipamento(ordemServico.getEquipamento());
        validaCliente(ordemServico.getCliente());
        validaAtendente(ordemServico.getAtendente());
        validaResponsavel(ordemServico.getResponsavel());
    }

    private void validaEquipamento(EquipamentoRequest equipamento) {
        ordemServicoValidaService.isUnicAtivoByPatrimonio(equipamento.getPatrimonio());
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
