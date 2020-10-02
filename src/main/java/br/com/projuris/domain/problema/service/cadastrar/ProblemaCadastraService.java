package br.com.projuris.domain.problema.service.cadastrar;

import br.com.projuris.api.v1.problema.model.request.ProblemaResumidoRequest;
import br.com.projuris.domain.problema.Problema;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

import java.util.List;

public interface ProblemaCadastraService extends ServiceDefault<Problema> {
    void cadastrar(List<ProblemaResumidoRequest> problemas, Long id);
}

