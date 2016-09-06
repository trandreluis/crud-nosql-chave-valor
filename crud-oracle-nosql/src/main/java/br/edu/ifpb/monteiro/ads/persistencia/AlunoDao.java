package br.edu.ifpb.monteiro.ads.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.edu.ifpb.monteiro.ads.excecoes.AlunoInexistenteException;
import br.edu.ifpb.monteiro.ads.excecoes.CrudException;
import br.edu.ifpb.monteiro.ads.excecoes.NaoExisteDadosException;
import br.edu.ifpb.monteiro.ads.json.ConverteJson;
import br.edu.ifpb.monteiro.ads.model.Aluno;
import oracle.kv.Key;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

//JsonObject json = ConverteJson.convertToAluno(ConverteJson.convertToJson(valueVersion.getValue().getValue()));
//
//Aluno aluno = new Aluno();
//
//aluno.setMatricula(json.get("matricula").getAsString());
//aluno.setCpf(json.get("cpf").getAsString());
//aluno.setCurso(json.get("curso").getAsString());
//aluno.setNome(json.get("nome").getAsString());
//aluno.setTelefone(json.get("telefone").getAsString());

public class AlunoDao extends GenericDao<Aluno, String> {

	private ArrayList<String> listaKeys = new ArrayList<String>();

	private PersistenciaKeys persistirKeys = new PersistenciaKeys(); 

	public AlunoDao() {
		// TODO Auto-generated constructor stub

		this.listaKeys = persistirKeys.recuperar("keys.xml");

	}

	@Override
	public
	void salvar(Aluno dado) throws CrudException {
		// TODO Auto-generated method stub

		validar.validarDado(dado);

		if(verificarExistencia(dado.getMatricula())){
			throw new AlunoInexistenteException();
		}else{

			ConexaoOracle.openStore();

			ConexaoOracle.getStore().put(Key.createKey(dado.getMatricula()),
					Value.createValue(ConverteJson.convertToJson(dado).getBytes()));

			ConexaoOracle.closeStore();

			listaKeys.add(dado.getMatricula());

			persistirKeys.salvar(listaKeys, "keys.xml");

		}
	}

	@Override
	public
	void atualizar(Aluno dado) throws CrudException {
		// TODO Auto-generated method stub

		validar.validarDado(dado);

		ConexaoOracle.openStore();

		ConexaoOracle.getStore().put(Key.createKey(dado.getMatricula()),
				Value.createValue(ConverteJson.convertToJson(dado).getBytes()));

		ConexaoOracle.closeStore();

	}

	@Override
	public
	void apagar(String dado) throws CrudException {
		// TODO Auto-generated method stub

		ConexaoOracle.openStore();

		ConexaoOracle.getStore().delete(Key.createKey(dado));
		
		listaKeys.remove(dado);
		
		persistirKeys.salvar(listaKeys, "keys.xml");

		ConexaoOracle.closeStore();
	}

	@Override
	public
	Aluno buscar(String chave) throws CrudException {
		// TODO Auto-generated method stub

		try {

			ConexaoOracle.openStore();

			final ValueVersion valueVersion = ConexaoOracle.getStore().get(Key.createKey(chave));

			Aluno aluno = ConverteJson.convertToAluno(new String(valueVersion.getValue().getValue()));

			ConexaoOracle.closeStore();

			return aluno;

		} catch (Exception e) {
			// TODO: handle exception
			throw new NaoExisteDadosException();
		}

	}

	@Override
	public
	List<Aluno> listar(){
		// TODO Auto-generated method stub

		ArrayList<Aluno> alunos = new ArrayList<Aluno>();

		ConexaoOracle.openStore();


			for(String key : getListaKeys()){

				final ValueVersion valueVersion = ConexaoOracle.getStore().get(Key.createKey(key));

				Aluno aluno = ConverteJson.convertToAluno(new String(valueVersion.getValue().getValue()));

				alunos.add(aluno);

		}

			return alunos;
		}



		public ArrayList<String> getListaKeys() {
			return listaKeys;
		}

		public boolean verificarExistencia(String chave) throws CrudException{
			// TODO Auto-generated method stub

			try {

				ConexaoOracle.openStore();

				final ValueVersion valueVersion = ConexaoOracle.getStore().get(Key.createKey(chave));

				ConverteJson.convertToAluno(ConverteJson.convertToJson(valueVersion.getValue().getValue()));

				ConexaoOracle.closeStore();

				return true;

			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}

		}

	}
