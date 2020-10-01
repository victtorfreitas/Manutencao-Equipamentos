package br.com.projuris.domain.ordemservico;

import lombok.Getter;

@Getter
public enum StatusOrdemServicoEnum {
    CADASTRADA("Cadastrada"),
    INICIADA("Iniciada"),
    PAUSADA("Pausada"),
    RETOMADA("Retomada"),
    CANCELADA("Cancelada"),
    CONCLUIDA("Concluída");

    private final String descricao;

    StatusOrdemServicoEnum(String descricao) {
        this.descricao = descricao;
    }
}
