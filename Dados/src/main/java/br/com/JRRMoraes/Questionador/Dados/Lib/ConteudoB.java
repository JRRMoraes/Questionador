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
		ArrayList<Class<?>> __lista = new ArrayList<Class<?>>();
		__lista.add(ObrigacaoQuestao.class);
		__lista.add(SelecaoExcelenteARuim.class);
		__lista.add(TipoEvento.class);
		__lista.add(TipoQuestao.class);
		__lista.add(TipoQuestaoEscolha.class);
		return __lista;
	}


	public static List<Class<?>> listarClassesDeEntidades() {
		ArrayList<Class<?>> __lista = new ArrayList<Class<?>>();
		__lista.add(Espectador.class);
		__lista.add(Evento.class);
		__lista.add(EventoPresenca.class);
		__lista.add(EventoQuestionario.class);
		__lista.add(EventoResposta.class);
		__lista.add(Projeto.class);
		__lista.add(ProjetoVersao.class);
		__lista.add(Questao.class);
		__lista.add(QuestaoEscolha.class);
		__lista.add(Questionario.class);
		__lista.add(Review.class);
		__lista.add(Usuario.class);
		return __lista;
	}


	public static List<Class<?>> listarClassesDeDAOs() {
		ArrayList<Class<?>> __lista = new ArrayList<Class<?>>();
		__lista.add(EspectadorDAO.class);
		__lista.add(EventoDAO.class);
		__lista.add(EventoPresencaDAO.class);
		__lista.add(EventoQuestionarioDAO.class);
		__lista.add(EventoRespostaDAO.class);
		__lista.add(ProjetoDAO.class);
		__lista.add(ProjetoVersaoDAO.class);
		__lista.add(QuestaoDAO.class);
		__lista.add(QuestaoEscolhaDAO.class);
		__lista.add(QuestionarioDAO.class);
		__lista.add(ReviewDAO.class);
		__lista.add(UsuarioDAO.class);
		return __lista;
	}


	public static List<Class<?>> listarClassesDeBeans() {
		ArrayList<Class<?>> __lista = new ArrayList<Class<?>>();
		__lista.add(EspectadorBean.class);
		__lista.add(EventoBean.class);
		__lista.add(EventoPresencaBean.class);
		__lista.add(EventoQuestionarioBean.class);
		__lista.add(EventoRespostaBean.class);
		__lista.add(ProjetoBean.class);
		__lista.add(ProjetoVersaoBean.class);
		__lista.add(QuestaoBean.class);
		__lista.add(QuestaoEscolhaBean.class);
		__lista.add(QuestionarioBean.class);
		__lista.add(ReviewBean.class);
		__lista.add(UsuarioBean.class);
		return __lista;
	}


	public static List<Class<?>> listarTodasAsClasses() {
		ArrayList<Class<?>> __lista = new ArrayList<Class<?>>();
		__lista.addAll(listarClassesDeConjuntos());
		__lista.addAll(listarClassesDeEntidades());
		// __lista.addAll(listarClassesDeDAOs());
		// __lista.addAll(listarClassesDeBeans());
		return __lista;
	}
}
