package br.com.JRRMoraes.Questionador.Dados;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Dados.Lib.Conexao;


public class TesteProjetoBeanCRUD {

	protected static ProjetoBean _projetoBean;


	@Before
	public void iniciar() {
		_projetoBean = new ProjetoBean();
	}


	@After
	public void finalizar() {
		EntityManager __gerenciador = Conexao.obterGerenciador();
		if (__gerenciador.getTransaction().isActive())
			__gerenciador.getTransaction().rollback();
		__gerenciador.clear();
		__gerenciador.close();
	}


	@Test
	public void consomeNovoERetornaNovo() {
		Projeto __projeto = _projetoBean.novo();
		assertNull("Id não é nulo", __projeto.getId());
		assertNull("Nome não é nulo", __projeto.getNome());
	}


	@Test
	public void consomeConsultarPorIdInexistenteRetornaNulo() {
		Projeto __projetoConsultarPorId = _projetoBean.consultarPorId(99l);
		assertNull("Projeto não é nulo", __projetoConsultarPorId);
	}


	@Test
	public void consomeNovoESalvarSemIdEhSucesso() {
		Projeto __projetoConsultarPorId = _projetoBean.consultarPorId(1l);
		assertNull("__projetoConsultarPorId não é nulo", __projetoConsultarPorId);
		Projeto __projetoNovo = _projetoBean.novo();
		assertNull("Id não é nulo", __projetoNovo.getId());
		__projetoNovo.setNome("Teste ID 1");
		assertTrue("Falha ao salvar", _projetoBean.salvar(__projetoNovo));
		assertNotNull("Id é nulo", __projetoNovo.getId());
		assertEquals("Id é diferente de 1", (Long) 1l, __projetoNovo.getId());
	}


	@Test
	public void consomeNovoESalvarComIdEhSucesso() {
		Projeto __projetoConsultarPorId = _projetoBean.consultarPorId(3l);
		assertNull("__projetoConsultarPorId não é nulo", __projetoConsultarPorId);
		Projeto __projetoNovo = _projetoBean.novo();
		assertNull("Id não é nulo", __projetoNovo.getId());
		__projetoNovo.setId(3l);
		__projetoNovo.setNome("Teste ID 3");
		assertTrue("Falha ao salvar", _projetoBean.salvar(__projetoNovo));
		assertNotNull("Id é nulo", __projetoNovo.getId());
		assertEquals("Id é diferente de 3", (Long) 3l, __projetoNovo.getId());
	}
}
