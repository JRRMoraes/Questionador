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
	}


	public static void imporAjustesFinais() {
		after("*", filtroImpoemConteudoGzipNaResposta);
		after(filtroImpoemTipoJsonNaResposta);
	}


	private static Route rotaOpcaoCorsNaResposta = (Request requisicao, Response resposta) -> {
		String cabecalho = requisicao.headers("Access-Control-Request-Headers");
		if (cabecalho != null) {
			resposta.header("Access-Control-Allow-Headers", cabecalho);
		}
		String metodo = requisicao.headers("Access-Control-Request-Method");
		if (metodo != null) {
			resposta.header("Access-Control-Allow-Methods", metodo);
		}
		return "OK";
	};


	private static Filter filtroImpoemCorsNaResposta = (Request requisicao, Response resposta) -> {
		resposta.header("Access-Control-Allow-Origin", "*");
	};


	private static Filter filtroImpoemConteudoGzipNaResposta = (Request requisicao, Response resposta) -> {
		resposta.header("Content-Encoding", "gzip");
	};


	private static Filter filtroImpoemTipoJsonNaResposta = (Request requisicao, Response resposta) -> {
		resposta.type("application/json");
	};
}