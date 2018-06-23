package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoQuestaoEscolha;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class QuestaoEscolha implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = 7986265955371004686L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idQuestaoEscolha")
	private Long id;

	@ManyToOne
	private Questao questao;

	private String texto;

	private char indice;

	@Enumerated(EnumType.STRING)
	private TipoQuestaoEscolha tipoQuestaoEscolha;
}