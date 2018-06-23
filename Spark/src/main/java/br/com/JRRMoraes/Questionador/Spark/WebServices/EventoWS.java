package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class EventoWS {

	public static void ImporCaminhos() {
		get(EventoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_NOVO, EventoWS.novo);
		get(EventoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_ID, EventoWS.consultarPorId);
		get(EventoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_TODOS, EventoWS.consultarTodos);
		get(EventoWS.CAMINHO_RAIZ + "abertos", EventoWS.consultarAbertos);
		post(EventoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_SALVAR, EventoWS.salvar);
	}


	private static EventoBean _eventoBean = new EventoBean();

	public final static String CAMINHO_RAIZ = "/evento/";


	public static Route novo = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _eventoBean.novo());
	};


	public static Route consultarPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilRequisicaoEResposta.ParametroID(requisicao);
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _eventoBean.consultarPorId(__id));
	};


	public static Route consultarTodos = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _eventoBean.consultarTodos());
	};


	public static Route consultarAbertos = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _eventoBean.consultarTodos());
	};


	public static Route salvar = (Request requisicao, Response resposta) -> {
		Evento __evento = _eventoBean.novo();
		return _eventoBean.salvar(__evento);
	};
}