package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Questao;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class QuestaoDAO extends DAOBase<Questao, Long> {

	public QuestaoDAO() {
		super(Questao.class);
	}


	public Questao novo() {
		return new Questao();
	}


	public boolean salvar(Questao questao) {
		return internoSalvar(questao);
	}


	public Questao consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<Questao> consultarTodos() {
		return internoCriarQuery("FROM Questao q ORDER BY q.indice").getResultList();
	}
}