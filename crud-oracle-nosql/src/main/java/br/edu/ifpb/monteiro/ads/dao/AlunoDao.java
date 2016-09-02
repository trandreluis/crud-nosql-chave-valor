package br.edu.ifpb.monteiro.ads.dao;


import br.edu.ifpb.monteiro.ads.model.Aluno;
import json.ConverteJson;
import oracle.kv.Key;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

public class AlunoDao extends GenericDao<Aluno, Long> {

	@Override
	void salvar(Aluno dado) {
		// TODO Auto-generated method stub

		store.put(Key.createKey(Long.toString(dado.getMatricula())), 
				Value.createValue(ConverteJson.convertToJson(dado).getBytes()));

	}

	@Override
	void atualizar(Aluno dado) {
		// TODO Auto-generated method stub

		store.putIfPresent(Key.createKey(Long.toString(dado.getMatricula())),
				Value.createValue(ConverteJson.convertToJson(dado).getBytes()));

	}

	@Override
	void apagar(Aluno dado) {
		// TODO Auto-generated method stub

		store.delete(Key.createKey(Long.toString(dado.getMatricula())));

	}

	@Override
	Aluno buscar(Long dado) {
		// TODO Auto-generated method stub

		final ValueVersion valueVersion = store.get(Key.createKey(Long.toString(dado)));

		return ConverteJson.convertToAluno(ConverteJson.convertToJson
				(valueVersion.getValue().getValue()));

	}

}
