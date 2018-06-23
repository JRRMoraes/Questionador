package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EventoPresencaDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoPresenca;


@Model
public class EventoPresencaBean {

	private EventoPresencaDAO _eventoPresencaDao = new EventoPresencaDAO();


	public EventoPresenca novo() {
		return _eventoPresencaDao.novo();
	}


	public boolean salvar(EventoPresenca eventoPresenca) {
		return _eventoPresencaDao.salvar(eventoPresenca);
	}


	public EventoPresenca consultarPorId(Long id) {
		return _eventoPresencaDao.consultarPorId(id);
	}


	public List<EventoPresenca> consultarTodos() {
		return _eventoPresencaDao.consultarTodos();
	}
}