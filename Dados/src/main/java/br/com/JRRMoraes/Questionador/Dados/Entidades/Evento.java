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
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Evento [idEvento="
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