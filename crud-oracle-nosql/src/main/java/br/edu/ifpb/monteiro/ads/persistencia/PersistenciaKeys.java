package br.edu.ifpb.monteiro.ads.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PersistenciaKeys {

	public void salvar(Object object, String nomeArquivo) {
		XStream xStream = new XStream(new DomDriver());
		String xml = xStream.toXML(object);

		try {
			File file = new File(nomeArquivo);

			if(!file.exists())
				file.createNewFile();
			PrintWriter escritor = new PrintWriter(file);
			escritor.write(xml);
			escritor.flush();
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> recuperar(String nomeDoArquivo) {
		File file = new File(nomeDoArquivo);

		XStream xStream = new XStream(new DomDriver());
		ArrayList<String> objeto = new ArrayList<String>();
		try {
			if(!file.exists()){
				salvar(new ArrayList<String>(), nomeDoArquivo);
			}

			FileReader ler = new FileReader(file);
			objeto = (ArrayList<String>) xStream.fromXML(ler);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return objeto;
	}
}
