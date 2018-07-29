package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;


@Model
public class EventoBean {

	private EventoDAO eventoDao = new EventoDAO();


	public Evento novo() {
		return eventoDao.novo();
	}


	public boolean salvar(Evento evento) {
		return eventoDao.salvar(evento);
	}


	public Evento consultarPorId(Long id) {
		return eventoDao.consultarPorId(id);
	}


	public List<Evento> consultarTodos() {
		return eventoDao.consultarTodos();
	}


	public List<Evento> consultarAbertos() {
		return eventoDao.consultarAbertos();
	}
}
