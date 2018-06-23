package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;


@Model
public class EventoBean {

	private EventoDAO _eventoDao = new EventoDAO();


	public Evento novo() {
		return _eventoDao.novo();
	}


	public boolean salvar(Evento evento) {
		return _eventoDao.salvar(evento);
	}


	public Evento consultarPorId(Long id) {
		return _eventoDao.consultarPorId(id);
	}


	public List<Evento> consultarTodos() {
		return _eventoDao.consultarTodos();
	}
}
