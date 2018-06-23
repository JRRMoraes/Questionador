package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestaoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Questao;


@Model
public class QuestaoBean {

	private QuestaoDAO _questaoDao = new QuestaoDAO();


	public Questao novo() {
		return _questaoDao.novo();
	}


	public boolean salvar(Questao questao) {
		return _questaoDao.salvar(questao);
	}


	public Questao consultarPorId(Long id) {
		return _questaoDao.consultarPorId(id);
	}


	public List<Questao> consultarTodos() {
		return _questaoDao.consultarTodos();
	}
}