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
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoVersaoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Dados.Entidades.ProjetoVersao;
import br.com.JRRMoraes.Questionador.Dados.Lib.Conexao;


public class TesteProjetoBean {

	protected static ProjetoBean projetoBean;

	protected static ProjetoVersaoBean projetoVersaoBean;

	private static final Logger logger = LogManager.getLogger(TesteProjetoBean.class);


	@Before
	public void iniciar() {
		projetoBean = new ProjetoBean();
		projetoVersaoBean = new ProjetoVersaoBean();
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
		assertNull("Projeto não é nulo", projetoBean.consultarPorId(10l));
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

		assertNull("projeto não é nulo", projetoBean.consultarPorId(novoId));

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

		assertNull("projeto não é nulo", projetoBean.consultarPorId(novoId));

		Projeto projetoNovo = projetoBean.novo();
		assertNull("Id não é nulo", projetoNovo.getId());
		projetoNovo.setId(novoId);
		projetoNovo.setNome("Teste ID novo");
		assertTrue("Falha ao salvar", projetoBean.salvar(projetoNovo));
		assertNotNull("Id é nulo", projetoNovo.getId());
		assertEquals("Id é igual ao projetoAnterior + 1", novoId, projetoNovo.getId());
	}


	@Test
	public void salvarProjetoEProjetoVersaoComBeansSeparadosEhSucesso() {
		logger.trace(">>> salvarProjetoEProjetoVersaoComBeansSeparadosEhSucesso()");
		Projeto projeto1 = projetoBean.novo();
		projeto1.setNome("Projeto AAA");
		assertTrue("Falha ao salvar", projetoBean.salvar(projeto1));

		ProjetoVersao projetoVersao1 = projetoVersaoBean.novo();
		projetoVersao1.setNome("AAA 1.1");
		assertTrue("Falha ao salvar", projetoVersaoBean.salvar(projetoVersao1));

		assertNotNull("projeto é nulo", projetoBean.consultarPorId(projeto1.getId()));
		assertNotNull("projetoVersao é nulo", projetoVersaoBean.consultarPorId(projetoVersao1.getId()));
	}


	@Test
	public void salvarProjetoEProjetoVersaoComProjetoVersaoBeanEhSucesso() {
		logger.trace(">>> salvarProjetoEProjetoVersaoComProjetoVersaoBeanEhSucesso()");
		Projeto projeto1 = projetoBean.novo();
		projeto1.setNome("Projeto BBB");

		ProjetoVersao projetoVersao1 = projetoVersaoBean.novo();
		projetoVersao1.setNome("BBB 1.1");
		projetoVersao1.setProjeto(projeto1);
		projetoVersaoBean.salvar(projetoVersao1);

		assertNotNull("projeto é nulo", projetoBean.consultarPorId(projeto1.getId()));
		assertNotNull("projetoVersao é nulo", projetoVersaoBean.consultarPorId(projetoVersao1.getId()));
	}


	@Test
	public void salvarProjetoEListaDeProjetosVersaoComProjetoBeanEhSucesso() {
		logger.trace(">>> salvarProjetoEListaDeProjetosVersaoComProjetoBeanEhSucesso()");
		ProjetoVersao projetoVersao1 = projetoVersaoBean.novo();
		projetoVersao1.setNome("CCC 1.1");

		ProjetoVersao projetoVersao2 = projetoVersaoBean.novo();
		projetoVersao2.setNome("CCC 2.2");

		ProjetoVersao projetoVersao3 = projetoVersaoBean.novo();
		projetoVersao3.setNome("CCC 3.3");

		Projeto projeto1 = projetoBean.novo();
		projeto1.setNome("Projeto CCC");
		projeto1.getVersoes().add(projetoVersao1);
		projeto1.getVersoes().add(projetoVersao2);
		projeto1.getVersoes().add(projetoVersao3);
		projetoBean.salvar(projeto1);

		assertNotNull("projetoVersao1 é nulo", projetoVersaoBean.consultarPorId(projetoVersao1.getId()));
		assertNotNull("projetoVersao2 é nulo", projetoVersaoBean.consultarPorId(projetoVersao2.getId()));
		assertNotNull("projetoVersao3 é nulo", projetoVersaoBean.consultarPorId(projetoVersao3.getId()));

		Projeto projetoSalvo = projetoBean.consultarPorId(projeto1.getId());
		assertNotNull("projeto é nulo", projetoSalvo);
		assertNotNull("projeto.versoes é nulo", projetoSalvo.getVersoes());
		assertEquals("projeto.versoes tem 3 versoes", 3, projetoSalvo.getVersoes().size());
	}


	/*
	 * @Test public void salvaProjetoVersaoNaoEhSucesso() {
	 * logger.trace(">>> salvaProjetoVersaoNaoEhSucesso()"); ProjetoVersao
	 * projetoVersao1 = projetoVersaoBean.novo();
	 * projetoVersao1.setNome("ZZZ 1.1");
	 * projetoVersaoBean.salvar(projetoVersao1);
	 * 
	 * ProjetoVersao projetoVersao2 =
	 * projetoVersaoBean.consultarPorId(projetoVersao1.getId());
	 * assertNull("projetoVersao não é nulo", projetoVersao2); }
	 */
}
