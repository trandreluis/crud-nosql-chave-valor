package br.edu.ifpb.monteiro.ads.excecoes;

@SuppressWarnings("serial")
public class MatriculaDuplicadaException extends CrudException {

	public MatriculaDuplicadaException() {
		super("Matrícula duplicada!");
	}
	
}
