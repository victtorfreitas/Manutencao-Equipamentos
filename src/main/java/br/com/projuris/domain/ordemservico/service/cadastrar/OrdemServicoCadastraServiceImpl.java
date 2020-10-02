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
import br.com.projuris.domain.exception.NegocioException;
import br.com.projuris.domain.funcionario.service.validar.FuncionarioValidarService;
import br.com.projuris.domain.ordemservico.OrdemServico;
import br.com.projuris.domain.ordemservico.StatusOrdemServicoEnum;
import br.com.projuris.domain.ordemservico.repository.cadastrar.OrdemServicoCadastraRepository;
import br.com.projuris.domain.ordemservico.service.validar.OrdemServicoValidaService;
import br.com.projuris.domain.problema.service.cadastrar.ProblemaCadastraService;
import br.com.projuris.domain.resultado.service.cadastrar.ResultadoCadastraService;
import br.com.projuris.infrastructure.abstracts.ServiceAbsDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.Optional;

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
    private final ProblemaCadastraService problemaCadastraService;

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
                                           ProblemaCadastraService problemaCadastraService) {
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
        this.problemaCadastraService = problemaCadastraService;
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

    private OrdemServicoResultadoResponse atualiza(ResultadoCadastrarRequest resultado, StatusOrdemServicoEnum status) {
        return atualiza(resultado, StatusOrdemServicoEnum.CANCELADA, null);
    }

    private OrdemServicoResultadoResponse atualiza(ResultadoCadastrarRequest resultado,
                                                   StatusOrdemServicoEnum status,
                                                   LocalDateTime dataFim) {
        ResultadoCompletoResponse resultadoCompletoResponse = cadastraNovoResultado(resultado);
        OrdemServico ordemServico = atualizaStatusOrdemServico(resultado.getOrdemServico().getId(), status, dataFim);
        return ordemServicoListarAssembler.toResultadoModel(ordemServico, resultadoCompletoResponse);
    }

    private OrdemServico atualizaStatusOrdemServico(Long id, StatusOrdemServicoEnum status, LocalDateTime dataFim) {
        Optional<OrdemServico> os = ordemServicoCadastraRepository
                .findById(id);
        if (os.isPresent()) {
            return ordemServicoCadastraRepository
                    .save(atualizaStatusOrdemServico(os.get(), status, dataFim));
        }
        throw new NegocioException("Ordem de serviço não encontrada");
    }

    @Override
    public OrdemServicoResultadoResponse pausaAntendimento(ResultadoCadastrarRequest resultado) {
        Long ordemServicoId = resultado.getOrdemServico().getId();
        podePausarAtendimento(ordemServicoId);
        return atualiza(resultado, StatusOrdemServicoEnum.PAUSADA);
    }

    @Override
    public OrdemServicoResultadoResponse retomarAntendimento(ResultadoCadastrarRequest resultado) {
        Long ordemServicoId = resultado.getOrdemServico().getId();
        podeRetomarAtendimento(ordemServicoId);
        return atualiza(resultado, StatusOrdemServicoEnum.RETOMADA);
    }

    @Override
    public OrdemServicoResultadoResponse cancelarAntendimento(ResultadoCadastrarRequest resultado) {
        podeCancelar(resultado.getOrdemServico().getId());
        return atualiza(resultado, StatusOrdemServicoEnum.CANCELADA, LocalDateTime.now());
    }

    private void podeCancelar(Long id) {
        validaOrdemServico(id);
    }

    private void podeRetomarAtendimento(Long ordemServicoId) {
        ordemServicoValidaService.podeRetomar(ordemServicoId);
    }

    private void podePausarAtendimento(Long ordemServicoId) {
        ordemServicoValidaService.podePausar(ordemServicoId);
    }

    private ResultadoCompletoResponse cadastraNovoResultado(ResultadoCadastrarRequest resultado) {
        return resultadoCadastraService.atualiza(resultado.getDescricao(), resultado.getOrdemServico().getId());
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

    private OrdemServico atualizaStatusOrdemServico(Long id, StatusOrdemServicoEnum status) {
        Optional<OrdemServico> os = ordemServicoCadastraRepository
                .findById(id);
        if (os.isPresent()) {
            return ordemServicoCadastraRepository
                    .save(atualizaStatusOrdemServico(os.get(), status));
        }
        throw new NegocioException("Ordem de serviço não encontrada");
    }

    private OrdemServico atualizaStatusOrdemServico(OrdemServico os, StatusOrdemServicoEnum iniciada) {
        return atualizaStatusOrdemServico(os, iniciada, null);
    }

    private OrdemServico atualizaStatusOrdemServico(OrdemServico os,
                                                    StatusOrdemServicoEnum iniciada,
                                                    LocalDateTime dataFTime) {
        os.setStatus(iniciada);
        os.setDataFim(dataFTime);
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
        Equipamento equipamentoBd = equipamentoListaService
                .findByPatrimonio(equipamento.getPatrimonio())
                .orElseGet(() -> equipamentoCadastraService.save(equipamento));
        problemaCadastraService.cadastrar(equipamento.getProblemas(), equipamentoBd.getId());
        return equipamentoBd;
    }
}
