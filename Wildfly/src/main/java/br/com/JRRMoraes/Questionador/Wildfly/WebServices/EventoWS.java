package br.com.JRRMoraes.Questionador.Wildfly.WebServices;


import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;


@Path("evento")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoWS {

	// @Inject
	private EventoBean eventoBean = new EventoBean();


	@Path("novo")
	@GET
	public Evento getNovo() {
		return eventoBean.novo();
	}


	@Path("{id:\\d+}")
	@GET
	public Evento getConsultarPorId(@PathParam("id") Long id) {
		return eventoBean.consultarPorId(id);
	}


	@Path("abertos")
	@GET
	public List<Evento> getConsultarEventosAbertos() {
		return eventoBean.consultarTodos();
	}


	@POST
	public Response postSalvar(Evento evento) {
		eventoBean.salvar(evento);
		return Response.created(URI.create(evento.getId().toString())).entity(evento).type(MediaType.APPLICATION_JSON)
				.build();
	}
}
