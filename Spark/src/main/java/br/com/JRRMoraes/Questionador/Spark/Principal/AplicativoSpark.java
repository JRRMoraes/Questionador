package br.com.JRRMoraes.Questionador.Spark.Principal;


import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;
import br.com.JRRMoraes.Questionador.Spark.Lib.Ajustes;
import br.com.JRRMoraes.Questionador.Spark.WebServices.EventoWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.ProjetoWS;
import spark.resource.Resource;
import spark.servlet.SparkApplication;


public class AplicativoSpark implements SparkApplication {

	private final Resource recurso;


	public AplicativoSpark(Resource recurso) {
		this.recurso = recurso;
	}


	@Override
	public void init() {
		port(9999);
		staticFiles.location("/public");
		staticFiles.expireTime(600L);
		enableDebugScreen();

		Ajustes.imporAjustesIniciais();

		EventoWS.imporCaminhos();
		ProjetoWS.imporCaminhos();
		// get("*", ViewUtil.notFound);

		Ajustes.imporAjustesFinais();
	}
}