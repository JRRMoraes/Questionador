package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import br.com.JRRMoraes.Questionador.Dados.Beans.EspectadorBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Espectador;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class EspectadorWS {

	public static void ImporCaminhos() {
		get(EspectadorWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_NOVO, EspectadorWS.novo);
		get(EspectadorWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_ID, EspectadorWS.consultarPorId);
		get(EspectadorWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_TODOS, EspectadorWS.consultarTodos);
		post(EspectadorWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_SALVAR, EspectadorWS.salvar);
	}


	private static EspectadorBean _espectadorBean = new EspectadorBean();

	public final static String CAMINHO_RAIZ = "/espectador/";


	public static Route novo = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _espectadorBean.novo());
	};


	public static Route consultarPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilRequisicaoEResposta.ParametroID(requisicao);
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _espectadorBean.consultarPorId(__id));
	};


	public static Route consultarTodos = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _espectadorBean.consultarTodos());
	};


	public static Route salvar = (Request requisicao, Response resposta) -> {
		Espectador __espectador = _espectadorBean.novo();
		return _espectadorBean.salvar(__espectador);
	};
}