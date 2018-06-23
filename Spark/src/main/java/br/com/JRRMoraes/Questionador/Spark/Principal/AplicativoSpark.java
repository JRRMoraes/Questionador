package br.com.JRRMoraes.Questionador.Spark.Principal;


import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;
import br.com.JRRMoraes.Questionador.Spark.Lib.Filtros;
import br.com.JRRMoraes.Questionador.Spark.WebServices.EventoWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.ProjetoWS;
import spark.resource.Resource;
import spark.servlet.SparkApplication;


public class AplicativoSpark implements SparkApplication {

	private final Resource _recurso;


	public AplicativoSpark(Resource recurso) {
		_recurso = recurso;
	}


	@Override
	public void init() {
		port(9999);
		staticFiles.location("/public");
		staticFiles.expireTime(600L);
		enableDebugScreen();

		Filtros.ImporFiltrosAnteriores();

		EventoWS.ImporCaminhos();
		ProjetoWS.ImporCaminhos();
		// get("*", ViewUtil.notFound);

		Filtros.ImporFiltrosFinais();
	}


	// Route map(Converter c) {
	// return (req, res) -> c.convert(req, res).handle(req, res);
	// }
	//
	// private interface Converter {
	// public ResponseCreator convert(Request req, Response res);
	// }
}

