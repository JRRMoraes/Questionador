package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.EventoResposta;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class EventoRespostaDAO extends DAOBase<EventoResposta, Long> {

	public EventoRespostaDAO() {
		super(EventoResposta.class);
	}


	public EventoResposta novo() {
		return new EventoResposta();
	}


	public boolean salvar(EventoResposta eventoResposta) {
		return internoSalvar(eventoResposta);
	}


	public EventoResposta consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<EventoResposta> consultarTodos() {
		return criarQuery("FROM FROM EventoResposta er ORDER BY er.nome").getResultList();
	}
}