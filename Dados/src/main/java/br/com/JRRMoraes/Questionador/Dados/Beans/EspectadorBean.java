package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EspectadorDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Espectador;


@Model
public class EspectadorBean {

	private EspectadorDAO espectadorDao = new EspectadorDAO();


	public Espectador novo() {
		return espectadorDao.novo();
	}


	public boolean salvar(Espectador espectador) {
		return espectadorDao.salvar(espectador);
	}


	public Espectador consultarPorId(Long id) {
		return espectadorDao.consultarPorId(id);
	}


	public List<Espectador> consultarTodos() {
		return espectadorDao.consultarTodos();
	}
}