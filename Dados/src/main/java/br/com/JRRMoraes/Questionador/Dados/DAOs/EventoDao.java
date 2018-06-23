package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class EventoDAO extends DAOBase<Evento, Long> {

	public EventoDAO() {
		super(Evento.class);
	}


	public Evento novo() {
		return new Evento();
	}


	public boolean salvar(Evento evento) {
		return internoSalvar(evento);
	}


	public Evento consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<Evento> consultarTodos() {
		return internoCriarQuery("FROM Evento e").getResultList();
	}
}