package br.edu.ifpb.monteiro.ads.excecoes;

@SuppressWarnings("serial")
public class AlunoInexistenteException extends CrudException {

	public AlunoInexistenteException() {
		super("Nao existe nenhum aluno com a matrícula passad!");
	}
	
}
