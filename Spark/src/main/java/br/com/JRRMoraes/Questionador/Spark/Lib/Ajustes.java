package br.com.JRRMoraes.Questionador.Spark.Lib;


import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.options;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;


public class Ajustes {

	public static void imporAjustesIniciais() {
		options("/*", rotaOpcaoCorsNaResposta);
		before(filtroImpoemCorsNaResposta);
		// before("*", filtroCuidaDeAlteracaoNoLocale);
	}


	public static void imporAjustesFinais() {
		after("*", filtroImpoemConteudoGzipNaResposta);
		after(filtroImpoemTipoJsonNaResposta);
	}


	private static Route rotaOpcaoCorsNaResposta = (Request requisicao, Response resposta) -> {
		String __cabecalho = requisicao.headers("Access-Control-Request-Headers");
		if (__cabecalho != null) {
			resposta.header("Access-Control-Allow-Headers", __cabecalho);
		}
		String __metodo = requisicao.headers("Access-Control-Request-Method");
		if (__metodo != null) {
			resposta.header("Access-Control-Allow-Methods", __metodo);
		}
		return "OK";
	};


	private static Filter filtroImpoemCorsNaResposta = (Request requisicao, Response resposta) -> {
		resposta.header("Access-Control-Allow-Origin", "*");
	};


	// Locale change can be initiated from any page
	// The locale is extracted from the request and saved to the user's session
	// private static Filter filtroCuidaDeAlteracaoNoLocale = (Request request,
	// Response
	// response) -> {
	// if (getQueryLocale(request) != null) {
	// request.session().attribute("locale", getQueryLocale(request));
	// response.redirect(request.pathInfo());
	// }
	// };


	private static Filter filtroImpoemConteudoGzipNaResposta = (Request requisicao, Response resposta) -> {
		resposta.header("Content-Encoding", "gzip");
	};


	private static Filter filtroImpoemTipoJsonNaResposta = (Request requisicao, Response resposta) -> {
		resposta.type("application/json");
	};
}