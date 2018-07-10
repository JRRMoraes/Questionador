package br.com.JRRMoraes.Questionador.Spark.Lib;


import org.eclipse.jetty.http.HttpStatus;
import spark.Response;


public class UtilRequisicaoEResposta {

	public static String responderSucesso(Response resposta, Object retorno) {
		// resposta.type("application/json");
		resposta.status(HttpStatus.OK_200);
		return Conversor.entidadeParaJson(retorno);
	}


	public static String reponderFalha(Response resposta, Object retorno) {
		// resposta.type("application/json");
		resposta.status(400);
		return Conversor.entidadeParaJson(retorno);
	}


	public static String naoEncontrado(Response resposta) {
		// resposta.type("application/json");
		resposta.status(HttpStatus.NOT_FOUND_404);
		return "";
	}
}