package br.edu.ifpb.monteiro.ads.dao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.edu.ifpb.monteiro.ads.model.Aluno;
import oracle.kv.Key;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

public class AlunoDao extends GenericDao<Aluno, Long> {

	private Gson gson = new Gson();

	@Override
	void salvar(Aluno dado) {
		// TODO Auto-generated method stub

		store.put(Key.createKey(Long.toString(dado.getMatricula())), 
				Value.createValue(gson.toJson(dado).getBytes()));
		
	}

	@Override
	void atualizar(Aluno dado) {
		// TODO Auto-generated method stub

		store.putIfPresent(Key.createKey(Long.toString(dado.getMatricula())), 
				Value.createValue(gson.toJson(dado).getBytes()));

	}

	@Override
	void apagar(Aluno dado) {
		// TODO Auto-generated method stub

		store.delete(Key.createKey(Long.toString(dado.getMatricula())));

	}

	@Override
	Aluno buscar(Long dado) {
		// TODO Auto-generated method stub

		final	ValueVersion valueVersion = store.get(Key.createKey(Long.toString(dado)));

		gson.toJson(valueVersion.getValue().getValue());
		


		return null;
	}

}
