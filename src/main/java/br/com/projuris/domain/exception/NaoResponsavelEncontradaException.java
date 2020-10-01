package br.com.projuris.domain.exception;

public class NaoResponsavelEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public NaoResponsavelEncontradaException(String mensagem) {
        super(mensagem);
    }

    public NaoResponsavelEncontradaException(Long responsavelId) {
        this(String.format("Funcionario com código %d não pode ser do tipo  Atendente", responsavelId));
    }

}
