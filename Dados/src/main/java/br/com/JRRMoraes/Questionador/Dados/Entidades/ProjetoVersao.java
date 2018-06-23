package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class ProjetoVersao implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = -2453684689129967999L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProjetoVersao")
	private Long id;

	@Column(length = 50)
	private String nome;

	@OneToOne
	private Projeto projeto;
}
