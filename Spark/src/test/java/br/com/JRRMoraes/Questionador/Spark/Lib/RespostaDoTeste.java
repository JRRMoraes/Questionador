package br.com.JRRMoraes.Questionador.Spark.Lib;


import static org.junit.Assert.fail;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import spark.utils.IOUtils;


public class RespostaDoTeste {

	public final String corpo;

	public final int status;


	public RespostaDoTeste(int status, String corpo) {
		this.status = status;
		this.corpo = corpo;
	}


	public Map<String, String> json() {
		return Conversor.jsonParaEntidade(HashMap.class, corpo);
	}


	public <E> E jsonParaEntidade(Class<E> classe) {
		return Conversor.jsonParaEntidade(classe, corpo);
	}


	public static RespostaDoTeste requerer(String metodo, String caminho) {
		int status = -1;
		String corpo = null;
		try {
			URL url = new URL("http://localhost:9999" + caminho);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			conexao.setRequestMethod(metodo);
			conexao.setDoOutput(true);
			conexao.connect();
			status = conexao.getResponseCode();
			corpo = IOUtils.toString(conexao.getInputStream());
			return new RespostaDoTeste(status, corpo);
		} catch (FileNotFoundException e) {
			return new RespostaDoTeste(status, corpo);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Falha ao enviar requisicao: " + e.getMessage());
			return null;
		}
	}
}