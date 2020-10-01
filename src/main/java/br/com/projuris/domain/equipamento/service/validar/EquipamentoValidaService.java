package br.com.projuris.domain.equipamento.service.validar;

import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface EquipamentoValidaService extends ServiceDefault<Equipamento> {
    void isUnicoAtivo(EquipamentoRequest equipamento);
}

