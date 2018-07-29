package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoRespostaDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoResposta;


@Model
public class EventoRespostaBean {

	private EventoRespostaDAO eventoRespostaDao = new EventoRespostaDAO();


	public EventoResposta novo() {
		return eventoRespostaDao.novo();
	}


	public boolean salvar(EventoResposta eventoResposta) {
		return eventoRespostaDao.salvar(eventoResposta);
	}


	public EventoResposta consultarPorId(Long id) {
		return eventoRespostaDao.consultarPorId(id);
	}


	public List<EventoResposta> consultarTodos() {
		return eventoRespostaDao.consultarTodos();
	}
}