package br.com.JRRMoraes.Questionador.Wildfly.WebServices;


import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.JRRMoraes.Questionador.Dados.Beans.ReviewBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Review;


@Path("PublicoWS/review")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewWS {

	// @Inject
	private ReviewBean reviewBean = new ReviewBean();


	@Path("novo")
	@GET
	public Review getNovo() {
		return reviewBean.novo();
	}


	@Path("salvar")
	@POST
	public Response postSalvar(Review review) {
		try {
			if (reviewBean.salvar(review)) {
				return Response.ok(review).build();
			}
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
		return Response.serverError().entity("Erro ao salvar").build();
	}


	@Path("consultarTodos")
	@GET
	public List<Review> getConsultarTodos() {
		return reviewBean.consultarTodos();
	}
}
