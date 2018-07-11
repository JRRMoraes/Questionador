package br.com.JRRMoraes.Questionador.Spark.Lib;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Test;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;


public class TesteEventoWS extends BaseTestes {

	@Test
	public void consultaPorIdInexistenteERetornaNulo() {
		RespostaDoTeste __resposta = RespostaDoTeste.requerer("GET", "/eventos/999");
		assertEquals(HttpStatus.NOT_FOUND_404, __resposta.status);
		Evento __evento = __resposta.jsonParaEntidade(Evento.class);
		assertNull("Evento não é nulo", __evento);
	}


	@Test
	public void consultaPorIdExistenteERetornaEventoValido() {
		RespostaDoTeste __resposta = RespostaDoTeste.requerer("GET", "/eventos/1");
		assertEquals(HttpStatus.OK_200, __resposta.status);
		Evento __evento = __resposta.jsonParaEntidade(Evento.class);
		assertNotNull("Evento é nulo", __evento);
		assertEquals("Evento.Id não é 1", (Long) 1l, __evento.getId());
	}
}