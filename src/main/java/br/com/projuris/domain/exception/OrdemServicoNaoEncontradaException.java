package br.com.projuris.domain.exception;

public class OrdemServicoNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public OrdemServicoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public OrdemServicoNaoEncontradaException(Long ordemServicoId) {
        this(String.format("Não existe uma ordem de serviço com código %d", ordemServicoId));
    }

}
