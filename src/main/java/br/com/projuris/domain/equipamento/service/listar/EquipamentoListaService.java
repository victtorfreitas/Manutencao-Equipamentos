package br.com.projuris.domain.equipamento.service.listar;

import br.com.projuris.domain.equipamento.Equipamento;
import br.com.projuris.infrastructure.interfaces.ServiceDefault;

import java.util.Optional;

public interface EquipamentoListaService extends ServiceDefault<Equipamento> {
    Optional<Equipamento> findByPatrimonio(String patrimonio);
}
