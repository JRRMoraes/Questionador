package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;


@Entity
public class Questionario implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = 3497546525344325646L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idQuestionario")
	private Long id;

	@Column(length = 50)
	private String nome;

	private Integer indice;

	@OneToMany(mappedBy = "questionario")
	private List<Questao> questoes;


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


	public Integer getIndice() {
		return indice;
	}


	public void setIndice(Integer indice) {
		this.indice = indice;
	}


	public List<Questao> getQuestoes() {
		return questoes;
	}


	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
}