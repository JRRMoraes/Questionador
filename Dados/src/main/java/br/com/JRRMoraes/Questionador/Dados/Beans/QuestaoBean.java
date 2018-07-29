package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestaoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Questao;


@Model
public class QuestaoBean {

	private QuestaoDAO questaoDao = new QuestaoDAO();


	public Questao novo() {
		return questaoDao.novo();
	}


	public boolean salvar(Questao questao) {
		return questaoDao.salvar(questao);
	}


	public Questao consultarPorId(Long id) {
		return questaoDao.consultarPorId(id);
	}


	public List<Questao> consultarTodos() {
		return questaoDao.consultarTodos();
	}
}