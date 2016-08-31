package br.edu.ifpb.monteiro.ads.model;

public class Aluno {

	private long matricula;
	private String nome, curso;

	public long getMatricula() {
		String str = Long.toString(matricula);
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", curso=" + curso + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}

	
	
}
