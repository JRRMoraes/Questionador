package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class EventoQuestionario implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = 4664830807376992987L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEventoQuestionario")
	private Long id;

	@ManyToOne
	private Evento evento;

	@ManyToOne
	private Questionario questionario;

	private Integer indice;
}