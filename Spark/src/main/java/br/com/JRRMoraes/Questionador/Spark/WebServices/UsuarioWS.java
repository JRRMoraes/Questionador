package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import br.com.JRRMoraes.Questionador.Dados.Beans.UsuarioBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Usuario;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilCaminho;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class UsuarioWS {

	private final static String CAMINHO_RAIZ = "/usuarios";

	private final static String CAMINHO_ID = UtilCaminho.caminhoId(CAMINHO_RAIZ);

	private static UsuarioBean _usuarioBean = new UsuarioBean();


	public static void imporCaminhos() {
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
			case "logar":
				return consultarLogin(requisicao, resposta);
		}
		return UtilRequisicaoEResposta.naoEncontrado(resposta);
	};


	private static Route rotaConsultaPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilCaminho.parametroId(requisicao);
		return UtilRequisicaoEResposta.responderSucesso(resposta, _usuarioBean.consultarPorId(__id));
	};


	private static Route rotaSalva = (Request requisicao, Response resposta) -> {
		Usuario __usuario = _usuarioBean.novo();
		return _usuarioBean.salvar(__usuario);
	};


	private static String consultarNovo(Request requisicao, Response resposta) {
		return UtilRequisicaoEResposta.responderSucesso(resposta, _usuarioBean.novo());
	}


	private static String consultarTodos(Request requisicao, Response resposta) {
		return UtilRequisicaoEResposta.responderSucesso(resposta, _usuarioBean.consultarTodos());
	}


	private static String consultarLogin(Request requisicao, Response resposta) {
		String __nome = requisicao.queryParams("N");
		String __senha = requisicao.queryParams("S");
		Usuario __usuario = _usuarioBean.logar(__nome, __senha);
		if (__usuario == null)
			return UtilRequisicaoEResposta.reponderFalha(resposta, __usuario);
		return UtilRequisicaoEResposta.responderSucesso(resposta, __usuario);
	}
}