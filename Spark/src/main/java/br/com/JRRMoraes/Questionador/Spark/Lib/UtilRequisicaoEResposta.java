package br.com.JRRMoraes.Questionador.Spark.Lib;


import spark.Request;
import spark.Response;


public class UtilRequisicaoEResposta {

	public static final String PARAM_NOVO = "novo";

	public static final String PARAM_ID = ":ID";

	public static final String PARAM_TODOS = "todos";

	public static final String PARAM_SALVAR = "salvar";


	public static String enviarJsonNaResposta(Response resposta, Object retorno) {
		resposta.type("application/json");
		resposta.status(200);
		return Conversor.entidadeParaJson(retorno);
	}


	public static Long ParametroLong(Request requisicao, String parametro) {
		try {
			String __valor = requisicao.params(parametro);
			return Long.parseLong(__valor, 10);
		} catch (Exception e) {
			return 0l;
		}
	}


	public static Long ParametroID(Request requisicao) {
		return ParametroLong(requisicao, UtilRequisicaoEResposta.PARAM_ID);
	}
}
