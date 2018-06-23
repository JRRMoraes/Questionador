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
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.SelecaoExcelenteARuim;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Review implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = -1681277312585869047L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReview")
	private Long id;

	@OneToOne
	private ProjetoVersao projetoVersao;

	@Column(length = 50)
	private String colaboradorNome;

	@Column(length = 50)
	private String colaboradorLogin;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	private Boolean reviewAtendeuSuasExpectativas;

	private String textoExpectativasDaReview;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private SelecaoExcelenteARuim aproveitamentoDaReview;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private SelecaoExcelenteARuim organizacaoDaReview;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private SelecaoExcelenteARuim apresentacaoDaReview;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private SelecaoExcelenteARuim conhecimentoDoInstrutor;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private SelecaoExcelenteARuim comunicacaoDoInstrutor;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private SelecaoExcelenteARuim explicacoesObjetivas;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private SelecaoExcelenteARuim receptividadeDoTimeAsCriticas;

	private String comentarios;
}
