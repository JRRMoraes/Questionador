package br.com.JRRMoraes.Questionador.Dados.Lib;


import br.com.JRRMoraes.Questionador.Dados.Beans.EspectadorBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoPresencaBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoQuestionarioBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoRespostaBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoVersaoBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.QuestaoBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.QuestaoEscolhaBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.QuestionarioBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.ReviewBean;
import br.com.JRRMoraes.Questionador.Dados.Beans.UsuarioBean;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EspectadorDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoPresencaDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoQuestionarioDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoRespostaDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ProjetoDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ProjetoVersaoDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestaoDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestaoEscolhaDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestionarioDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ReviewDAO;
import br.com.JRRMoraes.Questionador.Dados.DAOs.UsuarioDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Espectador;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoPresenca;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoQuestionario;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoResposta;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Dados.Entidades.ProjetoVersao;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Questao;
import br.com.JRRMoraes.Questionador.Dados.Entidades.QuestaoEscolha;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Questionario;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Review;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Usuario;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.ObrigacaoQuestao;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.SelecaoExcelenteARuim;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoEvento;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoQuestao;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoQuestaoEscolha;


public class Conteudo {

	public static Class[] listarClassesDeConjuntos() {
		Class[] lista = {
				ObrigacaoQuestao.class, SelecaoExcelenteARuim.class, TipoEvento.class, TipoQuestao.class,
				TipoQuestaoEscolha.class
		};
		return lista;
	}


	public static Class[] listarClassesDeEntidades() {
		Class[] lista = {
				Espectador.class, Evento.class, EventoPresenca.class, EventoQuestionario.class, EventoResposta.class,
				Projeto.class, ProjetoVersao.class, Questao.class, QuestaoEscolha.class, Questionario.class,
				Review.class, Usuario.class
		};
		return lista;
	}


	public static Class[] listarClassesDeDAOs() {
		Class[] lista = {
				EspectadorDAO.class, EventoDAO.class, EventoPresencaDAO.class, EventoQuestionarioDAO.class,
				EventoRespostaDAO.class, ProjetoDAO.class, ProjetoVersaoDAO.class, QuestaoDAO.class,
				QuestaoEscolhaDAO.class, QuestionarioDAO.class, ReviewDAO.class, UsuarioDAO.class
		};
		return lista;
	}


	public static Class[] listarClassesDeBeans() {
		Class[] lista = {
				EspectadorBean.class, EventoBean.class, EventoPresencaBean.class, EventoQuestionarioBean.class,
				EventoRespostaBean.class, ProjetoBean.class, ProjetoVersaoBean.class, QuestaoBean.class,
				QuestaoEscolhaBean.class, QuestionarioBean.class, ReviewBean.class, UsuarioBean.class
		};
		return lista;
	}


	/*
	 * public static Class[] listarTodasAsClasses() { int __tamanho =
	 * listarClassesDeConjuntos().length + listarClassesDeEntidades().length +
	 * listarClassesDeDAOs().length + listarClassesDeBeans().length; Class[]
	 * _lista = new Class[_tamanho]; Collections.addAll(c, elements)dAll(_lista,
	 * listarClassesDeConjuntos()); , listarClassesDeEntidades(),
	 * listarClassesDeDAOs(), listarClassesDeBeans());
	 * 
	 * Class[] lista = { listarClassesDeConjuntos(), listarClassesDeEntidades(),
	 * listarClassesDeDAOs(), listarClassesDeBeans() };return lista;
	 * 
	 * };
	 */
}
