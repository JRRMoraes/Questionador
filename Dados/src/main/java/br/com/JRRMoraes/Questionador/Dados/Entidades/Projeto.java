package br.com.JRRMoraes.Questionador.Dados.Entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.JRRMoraes.Questionador.Dados.Lib.IEntidade;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Projeto implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = -930433207657683940L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProjeto")
	private Long id;

	@Column(length = 20, nullable = false, unique = true)
	private String nome;
}
