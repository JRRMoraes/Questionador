package br.com.JRRMoraes.Questionador.Spark.Lib;


import com.google.gson.Gson;


public class Conversor {

	public static String entidadeParaJson(Object entidade) {
		return new Gson().toJson(entidade);
	}


	public static <E> E jsonParaEntidade(Class<E> classe, String json) {
		E __entidade = new Gson().fromJson(json, classe);
		return __entidade;
	}
}