package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class ProjetoDAO extends DAOBase<Projeto, Long> {

	public ProjetoDAO() {
		super(Projeto.class);
	}


	public Projeto novo() {
		return new Projeto();
	}


	public boolean salvar(Projeto projeto) {
		return internoSalvar(projeto);
	}


	public Projeto consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<Projeto> consultarTodos() {
		return criarQuery("FROM Projeto p ORDER BY p.nome").getResultList();
	}
}