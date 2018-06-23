package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoRespostaDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoResposta;


@Model
public class EventoRespostaBean {

	private EventoRespostaDAO _eventoRespostaDao = new EventoRespostaDAO();


	public EventoResposta novo() {
		return _eventoRespostaDao.novo();
	}


	public boolean salvar(EventoResposta eventoResposta) {
		return _eventoRespostaDao.salvar(eventoResposta);
	}


	public EventoResposta consultarPorId(Long id) {
		return _eventoRespostaDao.consultarPorId(id);
	}


	public List<EventoResposta> consultarTodos() {
		return _eventoRespostaDao.consultarTodos();
	}
}