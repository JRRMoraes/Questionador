package br.com.JRRMoraes.Questionador.Spark.Lib;


import spark.Request;


public enum RetornoAoCliente {

	_NAO(""),
	HTML("text/html"),
	JSON("application/json");


	private String _formato;

	private final static String CABECALHO = "Accept";


	private RetornoAoCliente(String formato) {
		_formato = formato;
	}


	public String getFormato() {
		return _formato;
	}


	public static RetornoAoCliente analisar(Request requisicao) {
		String __formato = requisicao.headers(CABECALHO);
		if (__formato == null) {
			return _NAO;
		} else if (__formato.contains(JSON.getFormato())) {
			return JSON;
		} else if (__formato.contains(HTML.getFormato())) {
			return HTML;
		}
		return _NAO;
	}
}