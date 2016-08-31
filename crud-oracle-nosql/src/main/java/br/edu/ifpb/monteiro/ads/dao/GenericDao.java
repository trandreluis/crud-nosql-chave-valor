package br.edu.ifpb.monteiro.ads.dao;

import br.edu.ifpb.monteiro.ads.model.Aluno;
import oracle.kv.KVStore;

/**
 * Dao Generico que ira fornecer as operacoes basicas de insercao, busca,
 * edicao, e exclusao no banco.
 */

public abstract class GenericDao<T, ID> {

	protected KVStore store;
	
	public GenericDao(){
		
		this.store = new ConexaoOracle().getStore();
		
	}
	
	abstract void salvar(T dado);

	abstract void atualizar(T dado);

	abstract void apagar(T dado);

	abstract T buscar(ID dado);
	
	protected void validarObjeto(Aluno dado){
		
		
		
	}

}