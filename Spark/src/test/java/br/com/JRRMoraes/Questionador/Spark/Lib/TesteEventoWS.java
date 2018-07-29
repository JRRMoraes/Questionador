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
		RespostaDoTeste resposta = RespostaDoTeste.requerer("GET", "/eventos/999");
		assertEquals(HttpStatus.NOT_FOUND_404, resposta.status);
		Evento evento = resposta.jsonParaEntidade(Evento.class);
		assertNull("Evento não é nulo", evento);
	}


	@Test
	public void consultaPorIdExistenteERetornaEventoValido() {
		RespostaDoTeste resposta = RespostaDoTeste.requerer("GET", "/eventos/1");
		assertEquals(HttpStatus.OK_200, resposta.status);
		Evento evento = resposta.jsonParaEntidade(Evento.class);
		assertNotNull("Evento é nulo", evento);
		assertEquals("Evento.Id não é 1", (Long) 1l, evento.getId());
	}
}