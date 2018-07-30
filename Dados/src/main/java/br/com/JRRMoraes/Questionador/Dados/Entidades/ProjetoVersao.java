package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;


@Entity
public class ProjetoVersao implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = -2453684689129967999L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProjetoVersao")
	private Long id;

	@Column(length = 50)
	private String nome;

	@ManyToOne(cascade = CascadeType.ALL)
	private Projeto projeto;


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


	public Projeto getProjeto() {
		return projeto;
	}


	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}