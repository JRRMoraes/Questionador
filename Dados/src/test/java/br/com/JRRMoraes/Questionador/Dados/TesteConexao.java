package br.com.JRRMoraes.Questionador.Dados;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import org.junit.Test;
import br.com.JRRMoraes.Questionador.Dados.Lib.Conexao;


public class TesteConexao {

	@Test
	public void consomeObterGerenciadorResultaSucesso() {
		EntityManager __gerenciador = Conexao.obterGerenciador();
		assertNotNull("Não é nulo", __gerenciador);
		assertTrue("Está fechado", __gerenciador.isOpen());
		// assertEquals("xxx",
		// __gerenciador.getEntityManagerFactory().toString(), "exx");
	}


	// @Test
	// public void consomeObterGerenciadorTemEntidadesListadas() {
	// EntityManager __gerenciador = Conexao.obterGerenciador();
	// assertTrue("Não tem Projeto", __gerenciador.contains(Projeto));
	// }
}
