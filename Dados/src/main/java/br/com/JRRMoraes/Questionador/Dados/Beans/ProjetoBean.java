package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ProjetoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;


@Model
public class ProjetoBean {

	private ProjetoDAO _projetoDao = new ProjetoDAO();


	public Projeto novo() {
		return _projetoDao.novo();
	}


	public boolean salvar(Projeto projeto) {
		return _projetoDao.salvar(projeto);
	}


	public Projeto consultarPorId(Long id) {
		return _projetoDao.consultarPorId(id);
	}


	public List<Projeto> consultarTodos() {
		return _projetoDao.consultarTodos();
	}
}