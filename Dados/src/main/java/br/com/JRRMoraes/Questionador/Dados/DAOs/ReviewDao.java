package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Review;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class ReviewDAO extends DAOBase<Review, Long> {

	public ReviewDAO() {
		super(Review.class);
	}


	public Review novo() {
		return new Review();
	}


	public boolean salvar(Review review) {
		return internoSalvar(review);
	}


	public Review consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<Review> consultarTodos() {
		return internoCriarQuery("FROM Review r ORDER BY r.nome").getResultList();
	}
}