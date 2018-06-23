package br.com.JRRMoraes.Questionador.Spark.Lib;


import static spark.Spark.after;
import spark.Filter;
import spark.Request;
import spark.Response;


public class Filtros {

	public static void ImporFiltrosAnteriores() {
		////// before("*", Filtros.adicionarBarraFinalNaRequisicao);
		// before("*", Filtros.cuidaDeAlteracaoNoLocale);
	}


	public static void ImporFiltrosFinais() {
		after("*", Filtros.imporConteudoGzipNaResposta);
	}


	protected static Filter adicionarBarraFinalNaRequisicao = (Request requisicao, Response resposta) -> {
		if (!requisicao.pathInfo().endsWith("/"))
			resposta.redirect(requisicao.pathInfo().concat("/"));
	};


	// Locale change can be initiated from any page
	// The locale is extracted from the request and saved to the user's session
	// public static Filter cuidaDeAlteracaoNoLocale = (Request request,
	// Response
	// response) -> {
	// if (getQueryLocale(request) != null) {
	// request.session().attribute("locale", getQueryLocale(request));
	// response.redirect(request.pathInfo());
	// }
	// };


	protected static Filter imporConteudoGzipNaResposta = (Request requisicao, Response resposta) -> {
		resposta.header("Content-Encoding", "gzip");
	};
}