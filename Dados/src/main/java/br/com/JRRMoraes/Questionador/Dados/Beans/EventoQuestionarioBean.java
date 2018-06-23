package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoQuestionarioDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoQuestionario;


@Model
public class EventoQuestionarioBean {

	private EventoQuestionarioDAO _eventoQuestionarioDao = new EventoQuestionarioDAO();


	public EventoQuestionario novo() {
		return _eventoQuestionarioDao.novo();
	}


	public boolean salvar(EventoQuestionario eventoQuestionario) {
		return _eventoQuestionarioDao.salvar(eventoQuestionario);
	}


	public EventoQuestionario consultarPorId(Long id) {
		return _eventoQuestionarioDao.consultarPorId(id);
	}


	public List<EventoQuestionario> consultarTodos() {
		return _eventoQuestionarioDao.consultarTodos();
	}
}