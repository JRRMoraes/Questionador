package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestionarioDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Questionario;


@Model
public class QuestionarioBean {

	private QuestionarioDAO questionarioDao = new QuestionarioDAO();


	public Questionario novo() {
		return questionarioDao.novo();
	}


	public boolean salvar(Questionario questionario) {
		return questionarioDao.salvar(questionario);
	}


	public Questionario consultarPorId(Long id) {
		return questionarioDao.consultarPorId(id);
	}


	public List<Questionario> consultarTodos() {
		return questionarioDao.consultarTodos();
	}
}