package br.com.JRRMoraes.Questionador.Dados;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Dados.Lib.Conexao;


public class TesteProjetoBean {

	protected static ProjetoBean projetoBean;

	private static final Logger logger = LogManager.getLogger(TesteProjetoBean.class);


	@Before
	public void iniciar() {
		projetoBean = new ProjetoBean();
	}


	@After
	public void finalizar() {
		logger.trace("... finalizar()");
		EntityManager gerenciador = Conexao.obterGerenciador();
		if (gerenciador.getTransaction().isActive())
			gerenciador.getTransaction().rollback();
		gerenciador.clear();
		gerenciador.close();
		Conexao.fecharFabrica();
	}


	@Test
	public void consomeNovoERetornaNovo() {
		logger.trace(">>> consomeNovoERetornaNovo()");
		Projeto projeto = projetoBean.novo();
		assertNull("Id não é nulo", projeto.getId());
		assertNull("Nome não é nulo", projeto.getNome());
	}


	@Test
	public void consomeConsultarPorIdInexistenteRetornaNulo() {
		logger.trace(">>> consomeConsultarPorIdInexistenteRetornaNulo()");
		Projeto projetoConsultarPorId = projetoBean.consultarPorId(10l);
		assertNull("Projeto não é nulo", projetoConsultarPorId);
	}


	@Test
	public void consomeConsultarPorIdExistenteRetornaSucesso() {
		logger.trace(">>> consomeConsultarPorIdExistenteRetornaSucesso()");
		Projeto projetoNovo = projetoBean.novo();
		assertNull("Id não é nulo", projetoNovo.getId());
		projetoNovo.setNome("Teste novo");
		assertTrue("Falha ao salvar", projetoBean.salvar(projetoNovo));

		Projeto projetoConsultarPorIdExistente = projetoBean.consultarPorId(projetoNovo.getId());
		assertNotNull("Projeto é nulo", projetoConsultarPorIdExistente);
		assertEquals("Id é diferente do projetoNovo", projetoNovo.getId(), projetoConsultarPorIdExistente.getId());
	}


	@Test
	public void consomeNovoESalvarSemIdEhSucesso() {
		logger.trace(">>> consomeNovoESalvarSemIdEhSucesso()");
		Projeto projetoAnterior = projetoBean.novo();
		assertNull("Id não é nulo", projetoAnterior.getId());
		projetoAnterior.setNome("Teste Anterior");
		assertTrue("Falha ao salvar", projetoBean.salvar(projetoAnterior));
		Long novoId = projetoAnterior.getId() + 1l;

		Projeto projetoConsultarPorId = projetoBean.consultarPorId(novoId);
		assertNull("projetoConsultarPorId não é nulo", projetoConsultarPorId);

		Projeto projetoNovo = projetoBean.novo();
		assertNull("Id não é nulo", projetoNovo.getId());
		projetoNovo.setNome("Teste ID novo");
		assertTrue("Falha ao salvar", projetoBean.salvar(projetoNovo));
		assertNotNull("Id é nulo", projetoNovo.getId());
		assertEquals("Id é igual ao projetoAnterior + 1", novoId, projetoNovo.getId());
	}


	@Test
	public void consomeNovoESalvarComIdEhSucesso() {
		logger.trace(">>> consomeNovoESalvarComIdEhSucesso()");
		Projeto projetoAnterior = projetoBean.novo();
		assertNull("Id não é nulo", projetoAnterior.getId());
		projetoAnterior.setNome("Teste Anterior");
		assertTrue("Falha ao salvar", projetoBean.salvar(projetoAnterior));
		Long novoId = projetoAnterior.getId() + 1l;

		Projeto projetoConsultarPorId = projetoBean.consultarPorId(novoId);
		assertNull("projetoConsultarPorId não é nulo", projetoConsultarPorId);

		Projeto projetoNovo = projetoBean.novo();
		assertNull("Id não é nulo", projetoNovo.getId());
		projetoNovo.setId(novoId);
		projetoNovo.setNome("Teste ID novo");
		assertTrue("Falha ao salvar", projetoBean.salvar(projetoNovo));
		assertNotNull("Id é nulo", projetoNovo.getId());
		assertEquals("Id é igual ao projetoAnterior + 1", novoId, projetoNovo.getId());
	}
}
