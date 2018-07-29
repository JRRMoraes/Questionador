package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.Path;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Dados.Lib.Consulta;
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
		return criarQuery("FROM Evento e").getResultList();
	}


	/*
	 * 
	 * public List<Evento> consultarAbertos() { Root<Evento> _raiz;
	 * CriteriaQuery<Evento> _criteria = criarCriteriaQuery(_raiz);
	 * Path<Calendar> _pathDtAbertura = _raiz.<Calendar> get("dtAbertura");
	 * Path<Calendar> _pathDtEncerramento = _raiz.<Calendar>
	 * get("dtEncerramento"); Predicate _predicadoDtAbertura =
	 * obterCriteriaBuilder().greaterThanOrEqualTo(_pathDtAbertura,
	 * Calendar.getInstance()); Predicate _predicadoDtEncerramento =
	 * obterCriteriaBuilder().lessThanOrEqualTo(_pathDtAbertura,
	 * Calendar.getInstance()); _criteria.where(_predicadoDtAbertura,
	 * _predicadoDtEncerramento);
	 * 
	 * TypedQuery<Evento> query = obterGerenciador().createQuery(_criteria);
	 * return query.getResultList(); }
	 */


	public List<Evento> consultarAbertos() {
		Consulta<Evento> consulta = criarConsulta();
		Path<Calendar> pathDataAbertura = consulta.raiz.<Calendar> get("dataAbertura");
		consulta.adicionarPredicado(consulta.construtor.lessThanOrEqualTo(pathDataAbertura, Calendar.getInstance()));
		Path<Calendar> pathDataEncerramento = consulta.raiz.<Calendar> get("dataEncerramento");
		consulta.adicionarPredicado(
				consulta.construtor.greaterThanOrEqualTo(pathDataEncerramento, Calendar.getInstance()));
		return consulta.criarTypedQuery().getResultList();
	}
}