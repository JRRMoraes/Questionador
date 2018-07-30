package br.com.JRRMoraes.Questionador.Dados.Teste;


import java.util.Calendar;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoVersaoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Dados.Entidades.ProjetoVersao;


public class PreencherEntidades {

	private static ProjetoBean projetoBean = new ProjetoBean();

	private static ProjetoVersaoBean projetoVersaoBean = new ProjetoVersaoBean();

	private static EventoBean eventoBean = new EventoBean();


	public static void main(String[] args) {
		preencherProjeto();
		preencherEvento();
	}


	private static void preencherProjeto() {
		Projeto projeto1 = projetoBean.novo();
		projeto1.setNome("Shop");
		ProjetoVersao projetoVersao11 = projetoVersaoBean.novo();
		projetoVersao11.setNome("Shop 6.1310");
		projeto1.getVersoes().add(projetoVersao11);
		ProjetoVersao projetoVersao12 = projetoVersaoBean.novo();
		projetoVersao12.setNome("Shop 6.1330");
		projeto1.getVersoes().add(projetoVersao12);
		projetoBean.salvar(projeto1);

		Projeto projeto2 = projetoBean.novo();
		projeto2.setNome("Bimer");
		ProjetoVersao projetoVersao21 = projetoVersaoBean.novo();
		projetoVersao21.setNome("Bimer 6.1301");
		projetoVersao21.setProjeto(projeto2);
		projetoVersaoBean.salvar(projetoVersao21);
	}


	private static void preencherEvento() {
		Evento evento1 = eventoBean.novo();
		evento1.setNome("Evento Número 1");
		evento1.setTexto("Evento encerrado");
		evento1.setDataCriacao(Calendar.getInstance());
		evento1.getDataCriacao().set(1980, 1, 12);
		evento1.setDataAbertura(Calendar.getInstance());
		evento1.getDataAbertura().set(1980, 1, 15);
		evento1.setDataEncerramento(Calendar.getInstance());
		evento1.getDataEncerramento().set(1980, 1, 25);
		eventoBean.salvar(evento1);

		Evento evento2 = eventoBean.novo();
		evento2.setNome("Evento Número 2");
		evento2.setTexto("Evento aberto");
		evento2.setDataCriacao(Calendar.getInstance());
		evento2.getDataCriacao().set(2018, 1, 1);
		evento2.setDataAbertura(Calendar.getInstance());
		evento2.getDataAbertura().set(2018, 1, 2);
		evento2.setDataEncerramento(Calendar.getInstance());
		evento2.getDataEncerramento().set(2999, 1, 1);
		eventoBean.salvar(evento2);
	}

}
