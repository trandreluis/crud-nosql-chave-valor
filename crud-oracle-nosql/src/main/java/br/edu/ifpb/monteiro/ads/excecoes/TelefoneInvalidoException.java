package br.edu.ifpb.monteiro.ads.excecoes;

@SuppressWarnings("serial")
public class TelefoneInvalidoException extends CrudException{
	
	public TelefoneInvalidoException() {
		super("Telefone inválido!");
	}
}