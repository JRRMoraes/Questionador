package br.com.JRRMoraes.Questionador.Spark.Lib;


import spark.Request;


public class UtilCaminho {

	public final static String FUNCAO_TODOS = "";

	public final static String FUNCAO_NOVO = "novo";

	private final static String PARAM_ID = ":ID";

	private final static String CAMINHO_ID = "/" + PARAM_ID;

	private final static String PARAM_FUNCAO = "funcao";


	public static String caminhoId(String caminhoBase) {
		return caminhoBase + CAMINHO_ID;
	}


	public static String parametroFuncao(Request requisicao) {
		String parametro = requisicao.queryParams(PARAM_FUNCAO);
		return (parametro != null) ? parametro : "";
	}


	public static Long parametroLong(Request requisicao, String parametro) {
		try {
			String valor = requisicao.params(parametro);
			return Long.parseLong(valor, 10);
		} catch (Exception e) {
			return 0l;
		}
	}


	public static Long parametroId(Request requisicao) {
		return parametroLong(requisicao, UtilCaminho.PARAM_ID);
	}
}