package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.QuestaoEscolhaDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.QuestaoEscolha;


@Model
public class QuestaoEscolhaBean {

	private QuestaoEscolhaDAO questaoEscolhaDao = new QuestaoEscolhaDAO();


	public QuestaoEscolha novo() {
		return questaoEscolhaDao.novo();
	}


	public boolean salvar(QuestaoEscolha questaoEscolha) {
		return questaoEscolhaDao.salvar(questaoEscolha);
	}


	public QuestaoEscolha consultarPorId(Long id) {
		return questaoEscolhaDao.consultarPorId(id);
	}


	public List<QuestaoEscolha> consultarTodos() {
		return questaoEscolhaDao.consultarTodos();
	}
}