package br.edu.ifpb.monteiro.ads.excecoes;

@SuppressWarnings("serial")
public class MatriculaInvalidaException extends CrudException {

	public MatriculaInvalidaException() {
		super("Matr�cula inv�lida!");
	}
}
