package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Usuario;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class UsuarioDAO extends DAOBase<Usuario, Long> {

	public UsuarioDAO() {
		super(Usuario.class);
	}


	public Usuario novo() {
		return new Usuario();
	}


	public boolean salvar(Usuario usuario) {
		return internoSalvar(usuario);
	}


	public Usuario consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<Usuario> consultarTodos() {
		return internoCriarQuery("FROM Usuario u ORDER BY u.nome").getResultList();
	}


	public Usuario logar(String nome, String senha) {
		try {
			TypedQuery<Usuario> __query = internoCriarQuery("FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha");
			__query.setParameter(":nome", nome);
			__query.setParameter(":senha", senha);
			return __query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}