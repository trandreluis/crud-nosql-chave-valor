package br.edu.ifpb.monteiro.ads.persistencia;

import java.util.List;

import br.edu.ifpb.monteiro.ads.excecoes.CrudException;
import br.edu.ifpb.monteiro.ads.validacoes.ValidarDado;

/**
 * Dao Generico que ira fornecer as operacoes basicas de insercao, busca,
 * edicao, e exclusao no banco.
 */

public abstract class GenericDao<T, ID> {

	protected ValidarDado validar;
	
	public GenericDao(){
		
		this.validar = new ValidarDado();
		
	}
	
	public abstract void salvar(T dado)throws CrudException;

	public abstract void atualizar(T dado)throws CrudException;

	public abstract void apagar(ID dado)throws CrudException;

	public abstract T buscar(ID dado)throws CrudException;
	
	public abstract List<T> listar() throws CrudException;
	
}