package json;


import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.edu.ifpb.monteiro.ads.model.Aluno;

public class ConverteJson {

	public static String convertToJson(Object obj) {
		String json = new Gson().toJson(obj);
		return json;
	}

	public static Aluno convertToAluno(String json) {
		Type type = new TypeToken<Aluno>() {
		}.getType();
		return new Gson().fromJson(json, type);
	}
	
}
