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


@Entity
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ProjetoVersao getProjetoVersao() {
		return projetoVersao;
	}


	public void setProjetoVersao(ProjetoVersao projetoVersao) {
		this.projetoVersao = projetoVersao;
	}


	public String getColaboradorNome() {
		return colaboradorNome;
	}


	public void setColaboradorNome(String colaboradorNome) {
		this.colaboradorNome = colaboradorNome;
	}


	public String getColaboradorLogin() {
		return colaboradorLogin;
	}


	public void setColaboradorLogin(String colaboradorLogin) {
		this.colaboradorLogin = colaboradorLogin;
	}


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public Boolean getReviewAtendeuSuasExpectativas() {
		return reviewAtendeuSuasExpectativas;
	}


	public void setReviewAtendeuSuasExpectativas(Boolean reviewAtendeuSuasExpectativas) {
		this.reviewAtendeuSuasExpectativas = reviewAtendeuSuasExpectativas;
	}


	public String getTextoExpectativasDaReview() {
		return textoExpectativasDaReview;
	}


	public void setTextoExpectativasDaReview(String textoExpectativasDaReview) {
		this.textoExpectativasDaReview = textoExpectativasDaReview;
	}


	public SelecaoExcelenteARuim getAproveitamentoDaReview() {
		return aproveitamentoDaReview;
	}


	public void setAproveitamentoDaReview(SelecaoExcelenteARuim aproveitamentoDaReview) {
		this.aproveitamentoDaReview = aproveitamentoDaReview;
	}


	public SelecaoExcelenteARuim getOrganizacaoDaReview() {
		return organizacaoDaReview;
	}


	public void setOrganizacaoDaReview(SelecaoExcelenteARuim organizacaoDaReview) {
		this.organizacaoDaReview = organizacaoDaReview;
	}


	public SelecaoExcelenteARuim getApresentacaoDaReview() {
		return apresentacaoDaReview;
	}


	public void setApresentacaoDaReview(SelecaoExcelenteARuim apresentacaoDaReview) {
		this.apresentacaoDaReview = apresentacaoDaReview;
	}


	public SelecaoExcelenteARuim getConhecimentoDoInstrutor() {
		return conhecimentoDoInstrutor;
	}


	public void setConhecimentoDoInstrutor(SelecaoExcelenteARuim conhecimentoDoInstrutor) {
		this.conhecimentoDoInstrutor = conhecimentoDoInstrutor;
	}


	public SelecaoExcelenteARuim getComunicacaoDoInstrutor() {
		return comunicacaoDoInstrutor;
	}


	public void setComunicacaoDoInstrutor(SelecaoExcelenteARuim comunicacaoDoInstrutor) {
		this.comunicacaoDoInstrutor = comunicacaoDoInstrutor;
	}


	public SelecaoExcelenteARuim getExplicacoesObjetivas() {
		return explicacoesObjetivas;
	}


	public void setExplicacoesObjetivas(SelecaoExcelenteARuim explicacoesObjetivas) {
		this.explicacoesObjetivas = explicacoesObjetivas;
	}


	public SelecaoExcelenteARuim getReceptividadeDoTimeAsCriticas() {
		return receptividadeDoTimeAsCriticas;
	}


	public void setReceptividadeDoTimeAsCriticas(SelecaoExcelenteARuim receptividadeDoTimeAsCriticas) {
		this.receptividadeDoTimeAsCriticas = receptividadeDoTimeAsCriticas;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}