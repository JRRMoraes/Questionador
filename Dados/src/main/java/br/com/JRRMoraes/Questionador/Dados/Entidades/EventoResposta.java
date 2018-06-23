package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class EventoResposta implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = -6172007447758666581L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEventoResposta")
	private Long id;

	@ManyToOne
	private Evento evento;

	@OneToOne
	private Questionario questionario;

	@OneToOne
	private Questao questao;

	@OneToOne
	private Espectador espectador;

	private String respostaLonga;

	private char respostaCurta;
}