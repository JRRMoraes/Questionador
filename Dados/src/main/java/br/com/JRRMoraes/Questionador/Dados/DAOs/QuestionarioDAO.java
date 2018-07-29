package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Questionario;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class QuestionarioDAO extends DAOBase<Questionario, Long> {

	public QuestionarioDAO() {
		super(Questionario.class);
	}


	public Questionario novo() {
		return new Questionario();
	}


	public boolean salvar(Questionario questionario) {
		return internoSalvar(questionario);
	}


	public Questionario consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<Questionario> consultarTodos() {
		return criarQuery("FROM Questionario q ORDER BY q.nome").getResultList();
	}
}