package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;


@Entity
public class Usuario implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = 5082182868915871314L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long id;

	@Column(length = 100)
	private String nome;

	@Column(length = 20)
	private String senha;

	@Column(length = 100)
	private String email;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}