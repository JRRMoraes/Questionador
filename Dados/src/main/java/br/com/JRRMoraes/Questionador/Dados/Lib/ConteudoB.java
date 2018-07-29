package br.com.JRRMoraes.Questionador.Dados.Lib;


import java.util.ArrayList;
import java.util.List;
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


public class ConteudoB {

	public static List<Class<?>> listarClassesDeConjuntos() {
		ArrayList<Class<?>> lista = new ArrayList<Class<?>>();
		lista.add(ObrigacaoQuestao.class);
		lista.add(SelecaoExcelenteARuim.class);
		lista.add(TipoEvento.class);
		lista.add(TipoQuestao.class);
		lista.add(TipoQuestaoEscolha.class);
		return lista;
	}


	public static List<Class<?>> listarClassesDeEntidades() {
		ArrayList<Class<?>> lista = new ArrayList<Class<?>>();
		lista.add(Espectador.class);
		lista.add(Evento.class);
		lista.add(EventoPresenca.class);
		lista.add(EventoQuestionario.class);
		lista.add(EventoResposta.class);
		lista.add(Projeto.class);
		lista.add(ProjetoVersao.class);
		lista.add(Questao.class);
		lista.add(QuestaoEscolha.class);
		lista.add(Questionario.class);
		lista.add(Review.class);
		lista.add(Usuario.class);
		return lista;
	}


	public static List<Class<?>> listarClassesDeDAOs() {
		ArrayList<Class<?>> lista = new ArrayList<Class<?>>();
		lista.add(EspectadorDAO.class);
		lista.add(EventoDAO.class);
		lista.add(EventoPresencaDAO.class);
		lista.add(EventoQuestionarioDAO.class);
		lista.add(EventoRespostaDAO.class);
		lista.add(ProjetoDAO.class);
		lista.add(ProjetoVersaoDAO.class);
		lista.add(QuestaoDAO.class);
		lista.add(QuestaoEscolhaDAO.class);
		lista.add(QuestionarioDAO.class);
		lista.add(ReviewDAO.class);
		lista.add(UsuarioDAO.class);
		return lista;
	}


	public static List<Class<?>> listarClassesDeBeans() {
		ArrayList<Class<?>> lista = new ArrayList<Class<?>>();
		lista.add(EspectadorBean.class);
		lista.add(EventoBean.class);
		lista.add(EventoPresencaBean.class);
		lista.add(EventoQuestionarioBean.class);
		lista.add(EventoRespostaBean.class);
		lista.add(ProjetoBean.class);
		lista.add(ProjetoVersaoBean.class);
		lista.add(QuestaoBean.class);
		lista.add(QuestaoEscolhaBean.class);
		lista.add(QuestionarioBean.class);
		lista.add(ReviewBean.class);
		lista.add(UsuarioBean.class);
		return lista;
	}


	public static List<Class<?>> listarTodasAsClasses() {
		ArrayList<Class<?>> lista = new ArrayList<Class<?>>();
		lista.addAll(listarClassesDeConjuntos());
		lista.addAll(listarClassesDeEntidades());
		// lista.addAll(listarClassesDeDAOs());
		// lista.addAll(listarClassesDeBeans());
		return lista;
	}
}
