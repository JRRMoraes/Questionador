package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoPresenca;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class EventoPresencaDAO extends DAOBase<EventoPresenca, Long> {

	public EventoPresencaDAO() {
		super(EventoPresenca.class);
	}


	public EventoPresenca novo() {
		return new EventoPresenca();
	}


	public boolean salvar(EventoPresenca eventoPresenca) {
		return internoSalvar(eventoPresenca);
	}


	public EventoPresenca consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<EventoPresenca> consultarTodos() {
		return criarQuery("FROM EventoPresenca ep").getResultList();
	}
}