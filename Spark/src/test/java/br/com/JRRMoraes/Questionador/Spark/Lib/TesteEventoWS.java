package br.com.JRRMoraes.Questionador.Spark.Lib;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Map;
import org.junit.Test;


public class TesteEventoWS extends BaseTestes {

	@Test
	public void consultaPorIdInexistenteERetornaNulo() {
		RespostaDoTeste __resposta = RespostaDoTeste.requerer("POST", "/eventos/999");
		Map<String, String> json = __resposta.json();
		assertEquals(400, __resposta.status);

		assertEquals("john", json.get("name"));
		assertEquals("john@foobar.com", json.get("email"));
		assertNotNull(json.get("id"));
	}


	@Test
	public void consultaPorIdExistenteERetornaEventoValido() {
		RespostaDoTeste __resposta = RespostaDoTeste.requerer("POST", "/eventos/1");
		Map<String, String> json = __resposta.json();
		assertEquals(200, __resposta.status);

		assertEquals("john", json.get("name"));
		assertEquals("john@foobar.com", json.get("email"));
		assertNotNull(json.get("id"));
	}
}
