package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ReviewDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Review;


@Model
public class ReviewBean {

	private ReviewDAO _reviewDao = new ReviewDAO();


	public Review novo() {
		return _reviewDao.novo();
	}


	public boolean salvar(Review review) {
		return _reviewDao.salvar(review);
	}


	public Review consultarPorId(Long id) {
		return _reviewDao.consultarPorId(id);
	}


	public List<Review> consultarTodos() {
		return _reviewDao.consultarTodos();
	}
}