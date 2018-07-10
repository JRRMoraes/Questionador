package br.com.JRRMoraes.Questionador.Spark.Principal;


import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;
import br.com.JRRMoraes.Questionador.Spark.Lib.Ajustes;
import br.com.JRRMoraes.Questionador.Spark.WebServices.EspectadorWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.EventoWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.ProjetoVersaoWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.ProjetoWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.ReviewWS;
import br.com.JRRMoraes.Questionador.Spark.WebServices.UsuarioWS;


public class Aplicativo {

	public static void main(String[] args) {
		port(9999);
		staticFiles.location("/public");
		staticFiles.expireTime(600L);
		enableDebugScreen();

		Ajustes.imporAjustesIniciais();

		EspectadorWS.ImporCaminhos();
		EventoWS.imporCaminhos();
		ProjetoVersaoWS.ImporCaminhos();
		ProjetoWS.imporCaminhos();
		ReviewWS.imporCaminhos();
		UsuarioWS.imporCaminhos();
		// get("*", ViewUtil.notFound);

		Ajustes.imporAjustesFinais();
	}
}