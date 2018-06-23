package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.ProjetoVersao;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class ProjetoVersaoDAO extends DAOBase<ProjetoVersao, Long> {

	public ProjetoVersaoDAO() {
		super(ProjetoVersao.class);
	}


	public ProjetoVersao novo() {
		return new ProjetoVersao();
	}


	public boolean salvar(ProjetoVersao projetoVersao) {
		return internoSalvar(projetoVersao);
	}


	public ProjetoVersao consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<ProjetoVersao> consultarTodos() {
		return internoCriarQuery("FROM ProjetoVersao pv ORDER BY pv.nome").getResultList();
	}
}