package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.UsuarioDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Usuario;


@Model
public class UsuarioBean {

	private UsuarioDAO _usuarioDao = new UsuarioDAO();


	public Usuario novo() {
		return _usuarioDao.novo();
	}


	public boolean salvar(Usuario usuario) {
		return _usuarioDao.salvar(usuario);
	}


	public Usuario consultarPorId(Long id) {
		return _usuarioDao.consultarPorId(id);
	}


	public Usuario logar(String nome, String senha) {
		return _usuarioDao.logar(nome, senha);
	}


	public List<Usuario> consultarTodos() {
		return _usuarioDao.consultarTodos();
	}
}