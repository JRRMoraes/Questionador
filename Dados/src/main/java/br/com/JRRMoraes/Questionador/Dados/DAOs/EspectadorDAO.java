package br.com.JRRMoraes.Questionador.Dados.DAOs;


import java.util.List;
import javax.ejb.Stateless;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Espectador;
import br.com.JRRMoraes.Questionador.Dados.Lib.DAOBase;


@Stateless
public class EspectadorDAO extends DAOBase<Espectador, Long> {

	public EspectadorDAO() {
		super(Espectador.class);
	}


	public Espectador novo() {
		return new Espectador();
	}


	public boolean salvar(Espectador espectador) {
		return internoSalvar(espectador);
	}


	public Espectador consultarPorId(Long id) {
		return internoConsultarPorId(id);
	}


	public List<Espectador> consultarTodos() {
		return internoCriarQuery("FROM Espectador e ORDER BY e.nome").getResultList();
	}
}