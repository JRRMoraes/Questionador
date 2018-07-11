package br.com.JRRMoraes.Questionador.Spark.Lib;


import static org.junit.Assert.fail;
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
		try {
			URL __url = new URL("http://localhost:9999" + caminho);
			HttpURLConnection __conexao = (HttpURLConnection) __url.openConnection();
			__conexao.setRequestMethod(metodo);
			__conexao.setDoOutput(true);
			__conexao.connect();
			String __corpo = IOUtils.toString(__conexao.getInputStream());
			return new RespostaDoTeste(__conexao.getResponseCode(), __corpo);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Falha ao enviar requisicao: " + e.getMessage());
			return null;
		}
	}
}