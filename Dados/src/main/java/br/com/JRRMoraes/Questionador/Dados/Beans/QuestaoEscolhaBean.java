package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestaoEscolhaDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.QuestaoEscolha;


@Model
public class QuestaoEscolhaBean {

	private QuestaoEscolhaDAO _questaoEscolhaDao = new QuestaoEscolhaDAO();


	public QuestaoEscolha novo() {
		return _questaoEscolhaDao.novo();
	}


	public boolean salvar(QuestaoEscolha questaoEscolha) {
		return _questaoEscolhaDao.salvar(questaoEscolha);
	}


	public QuestaoEscolha consultarPorId(Long id) {
		return _questaoEscolhaDao.consultarPorId(id);
	}


	public List<QuestaoEscolha> consultarTodos() {
		return _questaoEscolhaDao.consultarTodos();
	}
}