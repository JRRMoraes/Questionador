package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoEvento;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;


@Entity
public class Evento implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = 4601263782848320143L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEvento")
	private Long id;

	@Column(length = 50)
	private String nome;

	@Column(length = 256)
	private String texto;

	@OneToOne
	private ProjetoVersao projetoVersao;

	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEncerramento;


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


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public ProjetoVersao getProjetoVersao() {
		return projetoVersao;
	}


	public void setProjetoVersao(ProjetoVersao projetoVersao) {
		this.projetoVersao = projetoVersao;
	}


	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}


	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}


	public Calendar getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Calendar getDataEncerramento() {
		return dataEncerramento;
	}


	public void setDataEncerramento(Calendar dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}


	@Override
	public String toString() {
		return "Evento [id="
				+ id
				+ ", nome="
				+ nome
				+ ", texto="
				+ texto
				+ ", projetoVersao="
				+ projetoVersao
				+ ", tipoEvento="
				+ tipoEvento
				+ ", dataCriacao="
				+ dataCriacao
				+ ", dataEncerramento="
				+ dataEncerramento
				+ "]";
	}
}