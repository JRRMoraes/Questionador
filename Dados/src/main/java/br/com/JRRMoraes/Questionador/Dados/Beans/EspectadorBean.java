package br.com.JRRMoraes.Questionador.Dados.Beans;


import java.util.List;
import javax.enterprise.inject.Model;
import br.com.JRRMoraes.Questionador.Dados.DAOs.EspectadorDAO;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Espectador;


@Model
public class EspectadorBean {

	private EspectadorDAO _espectadorDao = new EspectadorDAO();


	public Espectador novo() {
		return _espectadorDao.novo();
	}


	public boolean salvar(Espectador espectador) {
		return _espectadorDao.salvar(espectador);
	}


	public Espectador consultarPorId(Long id) {
		return _espectadorDao.consultarPorId(id);
	}


	public List<Espectador> consultarTodos() {
		return _espectadorDao.consultarTodos();
	}
}