package br.edu.ifpb.monteiro.ads.excecoes;

@SuppressWarnings("serial")
public class CursoInvalidoException extends CrudException{
	
	public CursoInvalidoException() {
		super("Curso inválido!");
	}
}