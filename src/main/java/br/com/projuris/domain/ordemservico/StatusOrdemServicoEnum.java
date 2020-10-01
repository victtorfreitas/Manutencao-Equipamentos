package br.com.projuris.domain.ordemservico;

import lombok.Getter;

@Getter
public enum StatusOrdemServicoEnum {
    CADASTRADA("Cadastrada", "CADASTRADA"),
    INICIADA("Iniciada", "INICIADA"),
    PAUSADA("Pausada", "PAUSADA"),
    RETOMADA("Retomada", "RETOMADA"),
    CANCELADA("Cancelada", "CANCELADA"),
    CONCLUIDA("Concluída", "CONCLUIDA");

    private final String descricao;
    private final String valor;

    StatusOrdemServicoEnum(String descricao, String valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
