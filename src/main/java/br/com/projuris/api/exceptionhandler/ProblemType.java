package br.com.projuris.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    DADOS_INVALIDOS("Dados inválidos"),
    ACESSO_NEGADO("Acesso negado"),
    ERRO_DE_SISTEMA("Erro de sistema"),
    PARAMETRO_INVALIDO("Parâmetro inválido"),
    MENSAGEM_INCOMPREENSIVEL("Mensagem incompreensível"),
    RECURSO_NAO_ENCONTRADO("Recurso não encontrado"),
    ERRO_NEGOCIO("Violação de regra de negócio");

    private String title;

    ProblemType(String title) {
        this.title = title;
    }

}
