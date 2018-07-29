package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.Path;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Usuario;
import br.com.JRRMoraes.Questionador.Dados.Lib.Consulta;
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
		return criarQuery("FROM Usuario u ORDER BY u.nome").getResultList();
	}


	public Usuario logar(String nome, String senha) {
		Consulta<Usuario> consulta = criarConsulta();
		Path<String> pathNome = consulta.raiz.<String> get("nome");
		consulta.adicionarPredicado(consulta.construtor.equal(pathNome, nome));
		Path<String> pathSenha = consulta.raiz.<String> get("senha");
		consulta.adicionarPredicado(consulta.construtor.equal(pathSenha, senha));
		return consulta.criarTypedQuery().getSingleResult();
	}
}