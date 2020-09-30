package br.com.projuris.domain.exception;

public class FuncionarioNaoTipoAtendenteException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public FuncionarioNaoTipoAtendenteException(String mensagem) {
		super(mensagem);
	}

}
