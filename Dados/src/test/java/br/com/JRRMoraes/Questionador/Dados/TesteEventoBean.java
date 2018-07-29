package br.com.JRRMoraes.Questionador.Dados;


import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Dados.Lib.Conexao;


public class TesteEventoBean {

	protected static EventoBean eventoBean;

	private static final Logger logger = LogManager.getLogger(TesteEventoBean.class);


	@Before
	public void iniciar() {
		eventoBean = new EventoBean();
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
	public void consomeConsultarAbertosERetornaListaCorreta() {
		logger.trace(">>> consomeConsultarAbertosERetornaListaCorreta()");
		Evento evento1 = eventoBean.novo();
		evento1.setNome("Aberto");
		evento1.setDataAbertura(Calendar.getInstance());
		evento1.getDataAbertura().add(Calendar.DATE, -1);
		evento1.setDataEncerramento(Calendar.getInstance());
		evento1.getDataEncerramento().add(Calendar.DATE, +1);
		eventoBean.salvar(evento1);

		Evento evento2 = eventoBean.novo();
		evento2.setNome("Não");
		evento2.setDataAbertura(Calendar.getInstance());
		evento2.getDataAbertura().add(Calendar.DATE, -2);
		evento2.setDataEncerramento(Calendar.getInstance());
		evento2.getDataEncerramento().add(Calendar.DATE, -1);
		eventoBean.salvar(evento2);

		List<Evento> eventos = eventoBean.consultarAbertos();
		assertEquals("Diferente de 1 item", 1, eventos.size());
		assertEquals("Diferente do nome 'Aberto'", "Aberto", eventos.get(0).getNome());
		assertEquals("Diferente do id original", evento1.getId(), eventos.get(0).getId());
	}
}
