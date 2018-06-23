package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class EventoPresenca implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = 3474178056447622188L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEventoPresenca")
	private Long id;

	@ManyToOne
	private Evento evento;

	@ManyToOne
	private Espectador espectador;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
}