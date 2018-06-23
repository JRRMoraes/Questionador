package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.ProjetoVersaoDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.ProjetoVersao;


@Model
public class ProjetoVersaoBean {

	private ProjetoVersaoDAO _projetoVersaoDao = new ProjetoVersaoDAO();


	public ProjetoVersao novo() {
		return _projetoVersaoDao.novo();
	}


	public boolean salvar(ProjetoVersao projetoVersao) {
		return _projetoVersaoDao.salvar(projetoVersao);
	}


	public ProjetoVersao consultarPorId(Long id) {
		return _projetoVersaoDao.consultarPorId(id);
	}


	public List<ProjetoVersao> consultarTodos() {
		return _projetoVersaoDao.consultarTodos();
	}
}