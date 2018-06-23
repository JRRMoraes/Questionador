package br.com.JRRMoraes.Questionador.Wildfly.Interceptadores;


import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class InterceptadorDeCabecalhos implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Headers",
				"Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept, Authorization, X-Custom-header");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, HEAD, POST, DELETE, OPTIONS");
		responseContext.getHeaders().add("Access-Control-Expose-Headers", "Authorization");
	}
}
