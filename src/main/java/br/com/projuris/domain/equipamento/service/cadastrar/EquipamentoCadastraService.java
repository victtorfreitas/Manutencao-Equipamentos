package br.com.projuris.domain.equipamento.service.cadastrar;

import br.com.projuris.api.v1.equipamento.model.request.EquipamentoRequest;
import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

public interface EquipamentoCadastraService extends ServiceDefault<Equipamento> {
    Equipamento save(EquipamentoRequest equipamento);
}
