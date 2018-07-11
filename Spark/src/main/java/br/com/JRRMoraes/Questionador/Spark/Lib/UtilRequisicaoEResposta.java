package br.com.JRRMoraes.Questionador.Spark.Lib;


import org.eclipse.jetty.http.HttpStatus;
import spark.Response;


public class UtilRequisicaoEResposta {

	public static String responderSucesso(Response resposta, Object retorno) {
		resposta.status(HttpStatus.OK_200);
		return Conversor.entidadeParaJson(retorno);
	}


	public static String reponderFalha(Response resposta, Object retorno) {
		resposta.status(HttpStatus.NOT_FOUND_404);
		return Conversor.entidadeParaJson(retorno);
	}


	public static String reponderEntidade(Response resposta, Object entidade) {
		if (entidade == null)
			return reponderFalha(resposta, entidade);
		return responderSucesso(resposta, entidade);
	}


	public static String naoEncontrado(Response resposta) {
		resposta.status(HttpStatus.NOT_FOUND_404);
		return "";
	}


	public static <E> E respostaParaEntidade(Response resposta, Class<E> classe) {
		return Conversor.jsonParaEntidade(classe, resposta.body());
	}
}