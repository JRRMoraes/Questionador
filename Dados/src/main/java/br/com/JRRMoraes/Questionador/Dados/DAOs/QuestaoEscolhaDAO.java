package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.QuestaoEscolha;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class QuestaoEscolhaDAO extends DAOBase<QuestaoEscolha, Long> {

	public QuestaoEscolhaDAO() {
		super(QuestaoEscolha.class);
	}


	public QuestaoEscolha novo() {
		return new QuestaoEscolha();
	}


	public boolean salvar(QuestaoEscolha questaoEscolha) {
		return internoSalvar(questaoEscolha);
	}


	public QuestaoEscolha consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<QuestaoEscolha> consultarTodos() {
		return criarQuery("FROM QuestaoEscolha qe").getResultList();
	}
}