package br.com.JRRMoraes.Questionador.Dados.Lib;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;


public class DAOBase<E extends IEntidade<I>, I> {

	private Class<E> classe;

	// @PersistenceContext
	private EntityManager gerenciador;


	public DAOBase(Class<E> classe) {
		this.classe = classe;
		this.gerenciador = Conexao.obterGerenciador();
	}


	protected EntityManager obterGerenciador() {
		return gerenciador;
	}


	protected boolean internoSalvar(E entidade) {
		if (!gerenciador.getTransaction().isActive())
			gerenciador.getTransaction().begin();
		if (entidade.getId() == null)
			gerenciador.persist(entidade);
		else
			gerenciador.merge(entidade);
		gerenciador.flush();
		gerenciador.getTransaction().commit();
		return true;
	}


	protected E internoConsultarPorId(I id) {
		return gerenciador.find(classe, id);
	}


	public TypedQuery<E> criarQuery(String query) {
		return obterGerenciador().createQuery(query, classe);
	}


	public CriteriaBuilder obterCriteriaBuilder() {
		return obterGerenciador().getCriteriaBuilder();
	}


	public Consulta<E> criarConsulta() {
		return new Consulta<E>(classe, obterGerenciador());
	}
}