package br.com.projuris.domain.exception;

public class EquipamentoNaoUnicoAtivoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EquipamentoNaoUnicoAtivoException(String patrimonio) {
        super(String.format("Equipamento com uma ordem de serviço ativa %s", patrimonio));
    }

}
