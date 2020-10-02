package br.com.projuris.domain.exception;

public class NaoAtendenteEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public NaoAtendenteEncontradaException(String mensagem) {
        super(mensagem);
    }

    public NaoAtendenteEncontradaException(Long atendenteId) {
        this(String.format("Funcionario com código %d não é do tipo  Atendente", atendenteId));
    }

}
