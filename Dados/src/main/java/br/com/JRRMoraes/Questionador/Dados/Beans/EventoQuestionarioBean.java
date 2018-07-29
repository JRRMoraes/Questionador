package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoQuestionarioDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoQuestionario;


@Model
public class EventoQuestionarioBean {

	private EventoQuestionarioDAO eventoQuestionarioDao = new EventoQuestionarioDAO();


	public EventoQuestionario novo() {
		return eventoQuestionarioDao.novo();
	}


	public boolean salvar(EventoQuestionario eventoQuestionario) {
		return eventoQuestionarioDao.salvar(eventoQuestionario);
	}


	public EventoQuestionario consultarPorId(Long id) {
		return eventoQuestionarioDao.consultarPorId(id);
	}


	public List<EventoQuestionario> consultarTodos() {
		return eventoQuestionarioDao.consultarTodos();
	}
}