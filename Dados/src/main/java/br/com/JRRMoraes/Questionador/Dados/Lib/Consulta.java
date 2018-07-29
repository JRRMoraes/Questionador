package br.com.JRRMoraes.Questionador.Dados.Lib;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class Consulta<E> {

	public CriteriaBuilder construtor;

	public CriteriaQuery<E> query;

	public Root<E> raiz;

	private List<Predicate> predicados = new ArrayList<Predicate>();

	private Class<E> classe;

	private EntityManager gerenciador;


	public Consulta(Class<E> classe, EntityManager gerenciador) {
		this.classe = classe;
		this.gerenciador = gerenciador;
		construtor = gerenciador.getCriteriaBuilder();
		query = construtor.createQuery(classe);
		raiz = query.from(classe);
	}


	public void adicionarPredicado(Predicate predicado) {
		predicados.add(predicado);
	}


	public TypedQuery<E> criarTypedQuery() {
		if (!predicados.isEmpty())
			query.where(predicados.toArray(new Predicate[] {}));
		return gerenciador.createQuery(query);
	}
}