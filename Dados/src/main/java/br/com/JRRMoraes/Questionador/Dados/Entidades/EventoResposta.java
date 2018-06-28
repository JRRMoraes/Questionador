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


@Entity
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public Questionario getQuestionario() {
		return questionario;
	}


	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}


	public Questao getQuestao() {
		return questao;
	}


	public void setQuestao(Questao questao) {
		this.questao = questao;
	}


	public Espectador getEspectador() {
		return espectador;
	}


	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}


	public String getRespostaLonga() {
		return respostaLonga;
	}


	public void setRespostaLonga(String respostaLonga) {
		this.respostaLonga = respostaLonga;
	}


	public char getRespostaCurta() {
		return respostaCurta;
	}


	public void setRespostaCurta(char respostaCurta) {
		this.respostaCurta = respostaCurta;
	}
}