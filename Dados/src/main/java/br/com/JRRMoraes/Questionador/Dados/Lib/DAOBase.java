package br.com.JRRMoraes.Questionador.Dados.Lib;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class DAOBase<E extends IEntidade<I>, I> {

	private Class<E> _classe;

	// @PersistenceContext
	private EntityManager _gerenciador;


	public DAOBase(Class<E> classe) {
		_classe = classe;
		_gerenciador = Conexao.obterGerenciador();
	}


	protected EntityManager obterGerenciador() {
		return _gerenciador;
	}


	protected boolean internoSalvar(E entidade) {
		if (!_gerenciador.getTransaction().isActive())
			_gerenciador.getTransaction().begin();
		if (entidade.getId() == null)
			_gerenciador.persist(entidade);
		else
			_gerenciador.merge(entidade);
		_gerenciador.flush();
		_gerenciador.getTransaction().commit();
		return true;
	}


	protected E internoConsultarPorId(I id) {
		return _gerenciador.find(_classe, id);
	}


	public TypedQuery<E> internoCriarQuery(String query) {
		return obterGerenciador().createQuery(query, _classe);
	}
}