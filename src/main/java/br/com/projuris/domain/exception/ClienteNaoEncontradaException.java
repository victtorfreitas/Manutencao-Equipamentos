package br.com.projuris.domain.exception;

public class ClienteNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public ClienteNaoEncontradaException(Long clienteId) {
        this(String.format("Não existe um cadastro de cliente com código %d", clienteId));
    }

}
