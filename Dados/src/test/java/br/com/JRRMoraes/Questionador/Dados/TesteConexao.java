package br.com.JRRMoraes.Questionador.Dados;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import br.com.JRRMoraes.Questionador.Dados.Lib.Conexao;


public class TesteConexao {

	private static final Logger logger = LogManager.getLogger(TesteConexao.class);


	@After
	public void finalizar() {
		logger.trace("... finalizar()");
		Conexao.fecharFabrica();
	}


	@Test
	public void consomeObterGerenciadorResultaSucesso() {
		logger.trace(">>> consomeObterGerenciadorResultaSucesso()");
		EntityManager gerenciador = Conexao.obterGerenciador();
		assertNotNull("Não é nulo", gerenciador);
		assertTrue("Está fechado", gerenciador.isOpen());
		// assertEquals("xxx",
		// gerenciador.getEntityManagerFactory().toString(), "exx");
	}


	// @Test
	// public void consomeObterGerenciadorTemEntidadesListadas() {
	// EntityManager gerenciador = Conexao.obterGerenciador();
	// assertTrue("Não tem Projeto", gerenciador.contains(Projeto));
	// }
}
