package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ProjetoVersaoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.ProjetoVersao;


@Model
public class ProjetoVersaoBean {

	private ProjetoVersaoDAO projetoVersaoDao = new ProjetoVersaoDAO();


	public ProjetoVersao novo() {
		return projetoVersaoDao.novo();
	}


	public boolean salvar(ProjetoVersao projetoVersao) {
		return projetoVersaoDao.salvar(projetoVersao);
	}


	public ProjetoVersao consultarPorId(Long id) {
		return projetoVersaoDao.consultarPorId(id);
	}


	public List<ProjetoVersao> consultarTodos() {
		return projetoVersaoDao.consultarTodos();
	}
}