package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import br.com.JRRMoraes.Questionador.Dados.Beans.EspectadorBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Espectador;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilCaminho;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class EspectadorWS {

	private final static String CAMINHO_RAIZ = "/espectadores/";

	private final static String CAMINHO_ID = UtilCaminho.caminhoId(CAMINHO_RAIZ);

	private static EspectadorBean _espectadorBean = new EspectadorBean();


	public static void ImporCaminhos() {
		get(CAMINHO_RAIZ, rotaConsultaRaiz);
		get(CAMINHO_ID, rotaConsultaPorId);
		post(CAMINHO_RAIZ, rotaSalva);
		put(CAMINHO_ID, rotaSalva);
	}


	private static Route rotaConsultaRaiz = (Request requisicao, Response resposta) -> {
		switch (UtilCaminho.parametroFuncao(requisicao)) {
			case UtilCaminho.FUNCAO_TODOS:
				return consultarTodos(requisicao, resposta);
			case UtilCaminho.FUNCAO_NOVO:
				return consultarNovo(requisicao, resposta);
			case "abertos":
				return consultarAbertos(requisicao, resposta);
		}
		return UtilRequisicaoEResposta.naoEncontrado(resposta);
	};


	private static Route rotaConsultaPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilCaminho.parametroId(requisicao);
		return UtilRequisicaoEResposta.responderSucesso(resposta, _espectadorBean.consultarPorId(__id));
	};


	private static Route rotaSalva = (Request requisicao, Response resposta) -> {
		Espectador __espectador = _espectadorBean.novo();
		return _espectadorBean.salvar(__espectador);
	};


	private static String consultarNovo(Request requisicao, Response resposta) {
		return UtilRequisicaoEResposta.responderSucesso(resposta, _espectadorBean.novo());
	}


	private static String consultarTodos(Request requisicao, Response resposta) {
		return UtilRequisicaoEResposta.responderSucesso(resposta, _espectadorBean.consultarTodos());
	}


	private static String consultarAbertos(Request requisicao, Response resposta) {
		return UtilRequisicaoEResposta.responderSucesso(resposta, _espectadorBean.consultarTodos());
	}
}