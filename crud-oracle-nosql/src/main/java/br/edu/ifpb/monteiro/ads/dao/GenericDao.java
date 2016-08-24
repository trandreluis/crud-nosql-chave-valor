package br.edu.ifpb.monteiro.ads.dao;

/**
 * Dao Generico que ira fornecer as operacoes basicas de insercao, busca,
 * edicao, e exclusao no banco.
 */

public abstract class GenericDao<T, ID> {

	abstract void salvar(T dado);

	abstract void atualizar(T dado);

	abstract void apagar(T dado);

	abstract T buscar(ID dado);

}