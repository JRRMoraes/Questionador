package br.com.JRRMoraes.Questionador.Spark.Principal;


import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;
import br.com.JRRMoraes.Questionador.Spark.Lib.Filtros;
import br.com.JRRMoraes.Questionador.Spark.WebServices.EventoWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.ProjetoWS;


public class Aplicativo {

	public static void main(String[] args) {
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
}