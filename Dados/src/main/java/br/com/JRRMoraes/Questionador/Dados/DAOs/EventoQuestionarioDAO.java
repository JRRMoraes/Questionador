package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoQuestionario;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class EventoQuestionarioDAO extends DAOBase<EventoQuestionario, Long> {

	public EventoQuestionarioDAO() {
		super(EventoQuestionario.class);
	}


	public EventoQuestionario novo() {
		return new EventoQuestionario();
	}


	public boolean salvar(EventoQuestionario eventoQuestionario) {
		return internoSalvar(eventoQuestionario);
	}


	public EventoQuestionario consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<EventoQuestionario> consultarTodos() {
		return criarQuery("FROM EventoQuestionario eq").getResultList();
	}
}