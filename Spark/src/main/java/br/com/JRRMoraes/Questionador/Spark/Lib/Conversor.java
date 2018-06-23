package br.com.JRRMoraes.Questionador.Spark.Lib;


import java.io.IOException;
import java.io.StringWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class Conversor {

	public static String entidadeParaJson(Object entidade) {
		try {
			ObjectMapper __mapeador = new ObjectMapper();
			StringWriter __escritor = new StringWriter();
			__mapeador.enable(SerializationFeature.INDENT_OUTPUT);
			if (entidade != null)
				__mapeador.writeValue(__escritor, entidade);
			else
				__mapeador.writeValue(__escritor, "");
			return __escritor.toString();
		} catch (IOException e) {
			throw new RuntimeException("IOException ao mapear entidade (" + entidade + ") para JSON");
		}
	}


	// public static String entidadeParaHtml(Request requisicao, Map<String,
	// Object> modelo, String caminho) {
	// modelo.put("msg", new MessageBundle(getSessionLocale(requisicao)));
	// modelo.put("currentUser", getSessionCurrentUser(requisicao));
	// modelo.put("WebPath", Caminhos.class); // Access application URLs from
	// templates
	// return strictVelocityEngine().render(new ModelAndView(modelo, caminho));
	// }
}