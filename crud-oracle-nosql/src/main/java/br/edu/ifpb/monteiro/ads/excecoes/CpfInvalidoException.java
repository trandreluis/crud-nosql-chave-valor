package br.edu.ifpb.monteiro.ads.excecoes;

@SuppressWarnings("serial")
public class CpfInvalidoException extends CrudException {

	public CpfInvalidoException() {
		super("CPF inválido!");
	}
}

