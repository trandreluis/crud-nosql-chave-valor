package br.edu.ifpb.monteiro.ads.validacoes;

import br.edu.ifpb.monteiro.ads.excecoes.CpfInvalidoException;
import br.edu.ifpb.monteiro.ads.excecoes.CrudException;
import br.edu.ifpb.monteiro.ads.excecoes.CursoInvalidoException;
import br.edu.ifpb.monteiro.ads.excecoes.DadoInvalidoException;
import br.edu.ifpb.monteiro.ads.excecoes.MatriculaInvalidaException;
import br.edu.ifpb.monteiro.ads.excecoes.NomeInvalidoException;
import br.edu.ifpb.monteiro.ads.excecoes.TelefoneInvalidoException;
import br.edu.ifpb.monteiro.ads.model.Aluno;

public class ValidarDado {

	public void validarDado(Aluno dado) throws CrudException{

		if ((dado.getCpf() == null || dado.getCpf().equals("   .   .   -  "))
				&& (dado.getNome() == null || dado.getNome().trim()
				.equals(""))
				&& (dado.getCurso() == null || dado.getCurso().trim()
				.equals(""))
				&& (dado.getTelefone() == null || dado.getTelefone().equals(
						"(  )      -    "))
				&& (dado.getMatricula() == null || dado.getMatricula()
				.equals("            "))) {
			throw new DadoInvalidoException();

		} else if ((dado.getCpf() != null || !dado.getCpf().equals("   .   .   -  "))
				&& (dado.getNome() != null || !dado.getNome().trim()
				.equals(""))
				&& (dado.getCurso() != null || !dado.getCurso().trim()
				.equals(""))
				&& (dado.getTelefone() != null || !dado.getTelefone().equals(
						"(  )      -    "))
				&& (dado.getMatricula() == null || dado.getMatricula()
				.equals("            "))) {
			throw new MatriculaInvalidaException();
		} else if ((dado.getCpf() != null || !dado.getCpf().equals(
				"   .   .   -  "))
				&& (dado.getNome() == null || dado.getNome().trim()
				.equals(""))
				&& (dado.getCurso() != null || !dado.getCurso().trim()
				.equals(""))
				&& (dado.getTelefone() != null || !dado.getTelefone().equals(
						"(  )      -    "))
				&& (dado.getMatricula() != null || !dado.getMatricula()
				.equals("            "))) {
			throw new NomeInvalidoException();
		} else if ((dado.getCpf() == null || dado.getCpf().equals(
				"   .   .   -  "))
				&& (dado.getNome() != null || !dado.getNome().trim()
				.equals(""))
				&& (dado.getCurso() != null || !dado.getCurso().trim()
				.equals(""))
				&& (dado.getTelefone() != null || !dado.getTelefone().equals(
						"(  )      -    "))
				&& (dado.getMatricula() != null || !dado.getMatricula()
				.equals("            "))) {
			throw new CpfInvalidoException();
		} else if ((dado.getCpf() != null || !dado.getCpf().equals(
				"   .   .   -  "))
				&& (dado.getNome() != null || !dado.getNome().trim()
				.equals(""))
				&& (dado.getCurso() == null || dado.getCurso().trim()
				.equals(""))
				&& (dado.getTelefone() != null || !dado.getTelefone().equals(
						"(  )      -    "))
				&& (dado.getMatricula() != null || !dado.getMatricula()
				.equals("            "))) {
			throw new CursoInvalidoException();
		} else if ((dado.getCpf() != null || !dado.getCpf().equals(
				"   .   .   -  "))
				&& (dado.getNome() != null || !dado.getNome().trim()
				.equals(""))
				&& (dado.getCurso() != null || !dado.getCurso().trim()
				.equals(""))
				&& (dado.getTelefone() == null || dado.getTelefone().equals(
						"(  )      -    "))
				&& (dado.getMatricula() != null || !dado.getMatricula()
				.equals("            "))) {
			throw new TelefoneInvalidoException();
		}
	}

}
