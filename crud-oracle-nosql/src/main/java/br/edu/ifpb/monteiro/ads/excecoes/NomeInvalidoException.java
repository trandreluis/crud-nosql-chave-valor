package br.edu.ifpb.monteiro.ads.excecoes;

@SuppressWarnings("serial")
public class NomeInvalidoException extends CrudException{
	
	public NomeInvalidoException() {
		super("Nome inválido");
	}

}
