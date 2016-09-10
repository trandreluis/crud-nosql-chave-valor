package br.edu.ifpb.monteiro.ads.json;


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
		Aluno a = new Aluno();
		a =  new Gson().fromJson(json, Aluno.class);
		return a;
	}
	
	public static void main(String[] args) {
		Aluno a = new Aluno();
		a.setNome("Maria cabrita");
		String toJson = convertToJson(a);
		Aluno alunoInJson = convertToAluno(toJson);
		System.out.println(alunoInJson);
		

	}
	
	
//	public static String convert(Object obj){
//		String json = new Gson().toJson(obj);
//		return json;
//		}
//	
//	public static List<Speciality> loadJsonToObject(String json){
//		Type collectionType = new TypeToken<Collection<Speciality>>(){}.getType();
//		return new Gson().fromJson(json, collectionType);
//		}
	
}
