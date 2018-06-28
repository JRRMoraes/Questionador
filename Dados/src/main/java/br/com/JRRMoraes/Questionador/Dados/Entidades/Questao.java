package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.ObrigacaoQuestao;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoQuestao;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;


@Entity
public class Questao implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = -5617841281481093590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idQuestao")
	private Long id;

	private String texto;

	private String subtexto;

	private Integer indice;

	@Enumerated(EnumType.STRING)
	private ObrigacaoQuestao obrigacaoQuestao;

	@Enumerated(EnumType.STRING)
	private TipoQuestao tipoQuestao;

	@OneToMany(mappedBy = "questao")
	private List<QuestaoEscolha> escolhasDaQuestao;

	@ManyToOne
	private Questionario questionario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getSubtexto() {
		return subtexto;
	}


	public void setSubtexto(String subtexto) {
		this.subtexto = subtexto;
	}


	public Integer getIndice() {
		return indice;
	}


	public void setIndice(Integer indice) {
		this.indice = indice;
	}


	public ObrigacaoQuestao getObrigacaoQuestao() {
		return obrigacaoQuestao;
	}


	public void setObrigacaoQuestao(ObrigacaoQuestao obrigacaoQuestao) {
		this.obrigacaoQuestao = obrigacaoQuestao;
	}


	public TipoQuestao getTipoQuestao() {
		return tipoQuestao;
	}


	public void setTipoQuestao(TipoQuestao tipoQuestao) {
		this.tipoQuestao = tipoQuestao;
	}


	public List<QuestaoEscolha> getEscolhasDaQuestao() {
		return escolhasDaQuestao;
	}


	public void setEscolhasDaQuestao(List<QuestaoEscolha> escolhasDaQuestao) {
		this.escolhasDaQuestao = escolhasDaQuestao;
	}


	public Questionario getQuestionario() {
		return questionario;
	}


	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
}