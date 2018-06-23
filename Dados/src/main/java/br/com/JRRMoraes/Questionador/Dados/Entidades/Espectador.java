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
public class Espectador implements Serializable, IEntidade<Long> {

	private static final long serialVersionUID = 8763758291957983326L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEspectador")
	private Long id;

	@Column(length = 100)
	private String nome;

	@Column(length = 100)
	private String email;
}