package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ProjetoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;


@Model
public class ProjetoBean {

	private ProjetoDAO projetoDao = new ProjetoDAO();


	public Projeto novo() {
		return projetoDao.novo();
	}


	public boolean salvar(Projeto projeto) {
		return projetoDao.salvar(projeto);
	}


	public Projeto consultarPorId(Long id) {
		return projetoDao.consultarPorId(id);
	}


	public List<Projeto> consultarTodos() {
		return projetoDao.consultarTodos();
	}
}